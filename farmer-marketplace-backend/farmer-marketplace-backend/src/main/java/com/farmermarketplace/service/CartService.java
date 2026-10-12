package com.farmermarketplace.service;
import com.farmermarketplace.dto.CartRequest;
import com.farmermarketplace.entity.*;
import com.farmermarketplace.repository.CartItemRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CartService {
 private final CartItemRepository carts; private final UserService users; private final ProductService products;
 public CartService(CartItemRepository c,UserService u,ProductService p){carts=c;users=u;products=p;}
 public List<CartItem> get(Long customerId){checkCustomer(customerId);return carts.findByCustomerId(customerId);}
 public CartItem add(Long customerId,CartRequest r){
  User customer=checkCustomer(customerId); Product p=products.requireProduct(r.getProductId());
  if(r.getQuantity()<1||r.getQuantity()>p.getQuantity()) throw new IllegalArgumentException("Requested quantity is unavailable");
  CartItem item=carts.findByCustomerIdAndProductId(customerId,p.getId()).orElseGet(CartItem::new);
  item.setCustomer(customer);item.setProduct(p);item.setQuantity(r.getQuantity());return carts.save(item);
 }
 public void remove(Long customerId,Long itemId){
  CartItem item=carts.findById(itemId).orElseThrow(()->new IllegalArgumentException("Cart item not found"));
  if(!item.getCustomer().getId().equals(customerId)) throw new IllegalArgumentException("Cart item does not belong to customer");
  carts.delete(item);
 }
 public User checkCustomer(Long id){User u=users.requireUser(id);if(u.getRole()!=Role.CUSTOMER)throw new IllegalArgumentException("Only customers can use the cart");return u;}
 public CartItemRepository repository(){return carts;}
}

package com.farmermarketplace.service;
import com.farmermarketplace.dto.CheckoutRequest;
import com.farmermarketplace.entity.*;
import com.farmermarketplace.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service
public class OrderService {
 private final OrderRepository orders; private final CartService cart; private final ProductService products;
 public OrderService(OrderRepository o,CartService c,ProductService p){orders=o;cart=c;products=p;}
 @Transactional
 public CustomerOrder checkout(Long customerId,CheckoutRequest r){
  User customer=cart.checkCustomer(customerId); List<CartItem> items=cart.get(customerId);
  if(items.isEmpty()) throw new IllegalArgumentException("Cart is empty");
  CustomerOrder order=new CustomerOrder();order.setCustomer(customer);order.setDeliveryAddress(r.getDeliveryAddress());
  List<OrderItem> orderItems=new ArrayList<>();double total=0;
  for(CartItem ci:items){
   Product p=products.requireProduct(ci.getProduct().getId());
   if(ci.getQuantity()>p.getQuantity())throw new IllegalArgumentException("Insufficient stock for "+p.getName());
   p.setQuantity(p.getQuantity()-ci.getQuantity());
   OrderItem oi=new OrderItem();oi.setOrder(order);oi.setProduct(p);oi.setQuantity(ci.getQuantity());oi.setPriceAtPurchase(p.getPrice());
   orderItems.add(oi);total+=p.getPrice()*ci.getQuantity();
  }
  order.setItems(orderItems);order.setTotalAmount(total);
  CustomerOrder saved=orders.save(order);cart.repository().deleteByCustomerId(customerId);return saved;
 }
 public List<CustomerOrder> customerOrders(Long customerId){cart.checkCustomer(customerId);return orders.findByCustomerIdOrderByCreatedAtDesc(customerId);}
 public CustomerOrder get(Long id){return orders.findById(id).orElseThrow(()->new IllegalArgumentException("Order not found"));}
 public CustomerOrder updateStatus(Long farmerId,Long orderId,OrderStatus status){
  CustomerOrder o=get(orderId);
  boolean ownsProduct=o.getItems().stream().anyMatch(i->i.getProduct().getFarmer().getId().equals(farmerId));
  if(!ownsProduct)throw new IllegalArgumentException("This order does not include your products");
  o.setStatus(status);return orders.save(o);
 }
}

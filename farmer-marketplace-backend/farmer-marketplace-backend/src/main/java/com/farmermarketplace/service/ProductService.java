package com.farmermarketplace.service;
import com.farmermarketplace.dto.ProductRequest;
import com.farmermarketplace.entity.*;
import com.farmermarketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ProductService {
 private final ProductRepository products; private final UserService users;
 public ProductService(ProductRepository p,UserService u){products=p;users=u;}
 public List<Product> all(){return products.findAll();}
 public List<Product> search(String q){return products.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(q,q);}
 public List<Product> byFarmer(Long farmerId){return products.findByFarmerId(farmerId);}
 public Product add(Long farmerId,ProductRequest r){
  User farmer=users.requireUser(farmerId); if(farmer.getRole()!=Role.FARMER) throw new IllegalArgumentException("Only farmers can manage products");
  Product p=new Product(); apply(p,r); p.setFarmer(farmer); return products.save(p);
 }
 public Product update(Long farmerId,Long id,ProductRequest r){
  Product p=products.findById(id).orElseThrow(()->new IllegalArgumentException("Product not found"));
  if(!p.getFarmer().getId().equals(farmerId)) throw new IllegalArgumentException("You can update only your products");
  apply(p,r); return products.save(p);
 }
 public void delete(Long farmerId,Long id){
  Product p=products.findById(id).orElseThrow(()->new IllegalArgumentException("Product not found"));
  if(!p.getFarmer().getId().equals(farmerId)) throw new IllegalArgumentException("You can delete only your products");
  products.delete(p);
 }
 public Product requireProduct(Long id){return products.findById(id).orElseThrow(()->new IllegalArgumentException("Product not found"));}
 private void apply(Product p,ProductRequest r){
  if(r.getPrice()<0||r.getQuantity()<0) throw new IllegalArgumentException("Price and quantity cannot be negative");
  p.setName(r.getName());p.setDescription(r.getDescription());p.setCategory(r.getCategory());p.setPrice(r.getPrice());
  p.setQuantity(r.getQuantity());p.setUnit(r.getUnit());p.setImageUrl(r.getImageUrl());
 }
}

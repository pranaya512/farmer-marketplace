package com.farmermarketplace.entity;
import jakarta.persistence.*;
@Entity
public class OrderItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="order_id") private CustomerOrder order;
 @ManyToOne(optional=false) @JoinColumn(name="product_id") private Product product;
 private int quantity;
 private double priceAtPurchase;
 public OrderItem(){}
 public Long getId(){return id;} public CustomerOrder getOrder(){return order;} public void setOrder(CustomerOrder v){order=v;}
 public Product getProduct(){return product;} public void setProduct(Product v){product=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public double getPriceAtPurchase(){return priceAtPurchase;} public void setPriceAtPurchase(double v){priceAtPurchase=v;}
}

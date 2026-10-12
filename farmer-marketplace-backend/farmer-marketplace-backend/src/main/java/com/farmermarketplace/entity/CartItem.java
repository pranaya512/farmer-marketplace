package com.farmermarketplace.entity;
import jakarta.persistence.*;
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"customer_id","product_id"}))
public class CartItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="customer_id") private User customer;
 @ManyToOne(optional=false) @JoinColumn(name="product_id") private Product product;
 private int quantity;
 public CartItem(){}
 public Long getId(){return id;} public User getCustomer(){return customer;} public void setCustomer(User v){customer=v;}
 public Product getProduct(){return product;} public void setProduct(Product v){product=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
}

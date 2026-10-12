package com.farmermarketplace.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
@Entity
@Table(name="orders")
public class CustomerOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="customer_id") private User customer;
 @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true) private List<OrderItem> items=new ArrayList<>();
 private double totalAmount;
 @Enumerated(EnumType.STRING) private OrderStatus status=OrderStatus.PLACED;
 private String deliveryAddress;
 private LocalDateTime createdAt=LocalDateTime.now();
 public CustomerOrder(){}
 public Long getId(){return id;} public User getCustomer(){return customer;} public void setCustomer(User v){customer=v;}
 public List<OrderItem> getItems(){return items;} public void setItems(List<OrderItem> v){items=v;}
 public double getTotalAmount(){return totalAmount;} public void setTotalAmount(double v){totalAmount=v;}
 public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus v){status=v;}
 public String getDeliveryAddress(){return deliveryAddress;} public void setDeliveryAddress(String v){deliveryAddress=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}

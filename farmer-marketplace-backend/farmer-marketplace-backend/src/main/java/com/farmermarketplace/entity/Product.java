package com.farmermarketplace.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(length=1500) private String description;
 @Column(nullable=false) private String category;
 @Column(nullable=false) private double price;
 @Column(nullable=false) private int quantity;
 private String unit="kg";
 private String imageUrl;
 @ManyToOne(optional=false) @JoinColumn(name="farmer_id") private User farmer;
 private LocalDateTime createdAt=LocalDateTime.now();
 public Product(){}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public double getPrice(){return price;} public void setPrice(double v){price=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public String getUnit(){return unit;} public void setUnit(String v){unit=v;}
 public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
 public User getFarmer(){return farmer;} public void setFarmer(User v){farmer=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}

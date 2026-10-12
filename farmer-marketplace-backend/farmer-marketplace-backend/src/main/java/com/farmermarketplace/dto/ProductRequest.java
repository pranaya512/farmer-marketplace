package com.farmermarketplace.dto;
import jakarta.validation.constraints.*;
public class ProductRequest {
 @NotBlank private String name; private String description;
 @NotBlank private String category; @PositiveOrZero private double price;
 @PositiveOrZero private int quantity; private String unit="kg"; private String imageUrl;
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public double getPrice(){return price;} public void setPrice(double v){price=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public String getUnit(){return unit;} public void setUnit(String v){unit=v;}
 public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
}

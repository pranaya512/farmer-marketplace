package com.farmermarketplace.dto;
import jakarta.validation.constraints.*;
public class CartRequest {
 @NotNull private Long productId; @Min(1) private int quantity;
 public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
}

package com.farmermarketplace.dto;
import jakarta.validation.constraints.NotBlank;
public class CheckoutRequest {
 @NotBlank private String deliveryAddress;
 public String getDeliveryAddress(){return deliveryAddress;} public void setDeliveryAddress(String v){deliveryAddress=v;}
}

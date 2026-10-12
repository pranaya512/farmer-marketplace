package com.farmermarketplace.dto;
import com.farmermarketplace.entity.Role;
import jakarta.validation.constraints.*;
public class RegisterRequest {
 @NotBlank private String name;
 @Email @NotBlank private String email;
 @Size(min=6) private String password;
 @NotNull private Role role;
 private String phone; private String address;
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public Role getRole(){return role;} public void setRole(Role v){role=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getAddress(){return address;} public void setAddress(String v){address=v;}
}

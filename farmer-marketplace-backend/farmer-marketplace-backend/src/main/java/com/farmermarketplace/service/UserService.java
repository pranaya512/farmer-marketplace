package com.farmermarketplace.service;
import com.farmermarketplace.dto.*;
import com.farmermarketplace.entity.*;
import com.farmermarketplace.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
 private final UserRepository users; private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
 public UserService(UserRepository users){this.users=users;}
 public User register(RegisterRequest r){
  if(users.existsByEmail(r.getEmail().toLowerCase())) throw new IllegalArgumentException("Email is already registered");
  User u=new User(); u.setName(r.getName()); u.setEmail(r.getEmail().toLowerCase());
  u.setPassword(encoder.encode(r.getPassword())); u.setRole(r.getRole()); u.setPhone(r.getPhone()); u.setAddress(r.getAddress());
  return users.save(u);
 }
 public User login(LoginRequest r){
  User u=users.findByEmail(r.getEmail().toLowerCase()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
  if(!encoder.matches(r.getPassword(),u.getPassword())) throw new IllegalArgumentException("Invalid email or password");
  return u;
 }
 public User requireUser(Long id){return users.findById(id).orElseThrow(()->new IllegalArgumentException("User not found"));}
 public User publicUser(User u){u.setPassword(null);return u;}
}

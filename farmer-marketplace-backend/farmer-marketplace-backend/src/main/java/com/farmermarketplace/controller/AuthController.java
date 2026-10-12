package com.farmermarketplace.controller;
import com.farmermarketplace.dto.*;
import com.farmermarketplace.entity.User;
import com.farmermarketplace.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/auth")
public class AuthController {
 private final UserService service;
 public AuthController(UserService s){service=s;}
 @PostMapping("/register") public User register(@Valid @RequestBody RegisterRequest r){return service.publicUser(service.register(r));}
 @PostMapping("/login") public Map<String,Object> login(@Valid @RequestBody LoginRequest r){
  User u=service.publicUser(service.login(r));return Map.of("message","Login successful","user",u);
 }
}

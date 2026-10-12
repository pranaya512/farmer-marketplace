package com.farmermarketplace.controller;
import com.farmermarketplace.dto.CartRequest;
import com.farmermarketplace.entity.CartItem;
import com.farmermarketplace.service.CartService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/cart")
public class CartController {
 private final CartService service;
 public CartController(CartService s){service=s;}
 @GetMapping("/{customerId}") public List<CartItem> get(@PathVariable Long customerId){return service.get(customerId);}
 @PostMapping("/{customerId}") public CartItem add(@PathVariable Long customerId,@Valid @RequestBody CartRequest r){return service.add(customerId,r);}
 @DeleteMapping("/{customerId}/items/{itemId}") public void remove(@PathVariable Long customerId,@PathVariable Long itemId){service.remove(customerId,itemId);}
}

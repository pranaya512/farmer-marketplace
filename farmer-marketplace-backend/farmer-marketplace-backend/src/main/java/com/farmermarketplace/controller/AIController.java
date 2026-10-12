package com.farmermarketplace.controller;
import com.farmermarketplace.entity.Product;
import com.farmermarketplace.service.AiService;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/ai")
public class AIController {
 private final AiService service;
 public AIController(AiService s){service=s;}
 @GetMapping("/price-prediction/{productId}") public Map<String,Object> price(@PathVariable Long productId){return service.predictPrice(productId);}
 @GetMapping("/recommendations/{productId}") public List<Product> recommendations(@PathVariable Long productId){return service.recommend(productId);}
}

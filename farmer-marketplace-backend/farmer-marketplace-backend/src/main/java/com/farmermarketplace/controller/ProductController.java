package com.farmermarketplace.controller;
import com.farmermarketplace.dto.ProductRequest;
import com.farmermarketplace.entity.Product;
import com.farmermarketplace.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/products")
public class ProductController {
 private final ProductService service;
 public ProductController(ProductService s){service=s;}
 @GetMapping public List<Product> all(@RequestParam(required=false) String search){return search==null||search.isBlank()?service.all():service.search(search);}
 @GetMapping("/farmer/{farmerId}") public List<Product> farmerProducts(@PathVariable Long farmerId){return service.byFarmer(farmerId);}
 @PostMapping("/farmer/{farmerId}") public Product add(@PathVariable Long farmerId,@Valid @RequestBody ProductRequest r){return service.add(farmerId,r);}
 @PutMapping("/{id}/farmer/{farmerId}") public Product update(@PathVariable Long id,@PathVariable Long farmerId,@Valid @RequestBody ProductRequest r){return service.update(farmerId,id,r);}
 @DeleteMapping("/{id}/farmer/{farmerId}") public void delete(@PathVariable Long id,@PathVariable Long farmerId){service.delete(farmerId,id);}
}

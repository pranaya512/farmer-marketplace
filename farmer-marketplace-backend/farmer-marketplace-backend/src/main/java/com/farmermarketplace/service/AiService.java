package com.farmermarketplace.service;
import com.farmermarketplace.entity.Product;
import com.farmermarketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AiService {
 private final ProductRepository products;
 public AiService(ProductRepository products){this.products=products;}
 // Baseline estimate only; replace with a trained model and historical market-price data for real AI predictions.
 public Map<String,Object> predictPrice(Long productId){
  Product p=products.findById(productId).orElseThrow(()->new IllegalArgumentException("Product not found"));
  double current=p.getPrice();
  Map<String,Object> result=new LinkedHashMap<>();
  result.put("productId",p.getId());result.put("productName",p.getName());
  result.put("currentPrice",current);result.put("suggestedLow",Math.round(current*0.90*100.0)/100.0);
  result.put("suggestedHigh",Math.round(current*1.10*100.0)/100.0);
  result.put("note","Demo estimate based on current listing price, not a trained AI market prediction.");
  return result;
 }
 // Simple content-based recommendation baseline using category and recent listing order.
 public List<Product> recommend(Long productId){
  Product selected=products.findById(productId).orElseThrow(()->new IllegalArgumentException("Product not found"));
  return products.findByCategoryIgnoreCase(selected.getCategory()).stream()
    .filter(p->!p.getId().equals(productId)).limit(5).toList();
 }
}

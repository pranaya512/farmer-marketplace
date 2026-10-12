package com.farmermarketplace.controller;
import com.farmermarketplace.dto.CheckoutRequest;
import com.farmermarketplace.entity.*;
import com.farmermarketplace.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/orders")
public class OrderController {
 private final OrderService service;
 public OrderController(OrderService s){service=s;}
 @PostMapping("/checkout/{customerId}") public CustomerOrder checkout(@PathVariable Long customerId,@Valid @RequestBody CheckoutRequest r){return service.checkout(customerId,r);}
 @GetMapping("/customer/{customerId}") public List<CustomerOrder> customerOrders(@PathVariable Long customerId){return service.customerOrders(customerId);}
 @GetMapping("/{id}") public CustomerOrder get(@PathVariable Long id){return service.get(id);}
 @PatchMapping("/{orderId}/farmer/{farmerId}/status") public CustomerOrder status(@PathVariable Long orderId,@PathVariable Long farmerId,@RequestParam OrderStatus status){return service.updateStatus(farmerId,orderId,status);}
}

package com.farmermarketplace.repository;
import com.farmermarketplace.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
 List<CartItem> findByCustomerId(Long customerId);
 Optional<CartItem> findByCustomerIdAndProductId(Long customerId,Long productId);
 void deleteByCustomerId(Long customerId);
}

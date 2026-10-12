package com.farmermarketplace.repository;
import com.farmermarketplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product,Long> {
 List<Product> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name,String category);
 List<Product> findByFarmerId(Long farmerId);
 List<Product> findByCategoryIgnoreCase(String category);
}

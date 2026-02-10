package ua.com.kisit.course2026np.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.course2026np.entity.ProductsHasOrder;

public interface ProductHasOrderRepository extends JpaRepository<ProductsHasOrder,Long> {
}

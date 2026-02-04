package ua.com.kisit.course2026np.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.course2026np.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}

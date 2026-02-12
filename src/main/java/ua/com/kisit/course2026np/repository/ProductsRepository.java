package ua.com.kisit.course2026np.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.entity.Products;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findByCategory(Categories category);

   // Optional<Products> findById(Long id);

}

package ua.com.kisit.course2026np.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.course2026np.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Categories findByName(String name);

}

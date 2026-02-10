package ua.com.kisit.course2026np.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.course2026np.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}

package ua.com.kisit.course2026np.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.course2026np.entity.Clients;

public interface ClientRepository extends JpaRepository<Clients, Long> {
}

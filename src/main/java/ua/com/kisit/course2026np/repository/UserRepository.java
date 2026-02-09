package ua.com.kisit.course2026np.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.course2026np.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

}

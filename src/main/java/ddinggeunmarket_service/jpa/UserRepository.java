package ddinggeunmarket_service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.id = :id")
    User getBoardById(@Param("id") String id);
}

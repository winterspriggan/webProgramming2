package ddinggeunmarket_service.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.id = :id")
    User getUserById(@Param("id") String id);

    @Query("select u from User u where u.email = :email")
    User getUserByEMail(@Param("email") String email);
}

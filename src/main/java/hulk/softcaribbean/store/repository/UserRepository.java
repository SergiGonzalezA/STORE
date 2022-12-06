package hulk.softcaribbean.store.repository;

import hulk.softcaribbean.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

    @Query("SELECT U FROM User U WHERE U.email = :email")
    User findByEmail(@Param("email") String email);

    //Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);


}

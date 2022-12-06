package hulk.softcaribbean.store.repository;

import hulk.softcaribbean.store.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository <Movement, Long>{
}

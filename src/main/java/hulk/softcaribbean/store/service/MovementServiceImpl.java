package hulk.softcaribbean.store.service;

import hulk.softcaribbean.store.entity.Movement;
import hulk.softcaribbean.store.repository.MovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImpl implements MovementService{

    private final MovementRepository movementRepository;

    public MovementServiceImpl(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }
}

package hulk.softcaribbean.store.controller;

import hulk.softcaribbean.store.controller.base.ApplicationCustomException;
import hulk.softcaribbean.store.entity.Movement;
import hulk.softcaribbean.store.service.MovementService;
import hulk.softcaribbean.store.util.MessagesConstants;
import hulk.softcaribbean.store.util.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovementCtrl {
    private static final String ENTITY_NAME = "Movement";

    private final MovementService movementService;

    public MovementCtrl(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping("/save-movement")
    public ResponseEntity<ResponseMessage<Movement>> save(@RequestBody Movement movement) throws ApplicationCustomException {
        Movement response;
        try {
            response = movementService.save(movement);
        } catch (Exception ex) {
            throw new ApplicationCustomException(MessagesConstants.DEFAULT_ERROR_CODE, String.format(MessagesConstants.DEFAULT_ERROR_MESSAGE, ex.getMessage()));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, MessagesConstants.DEFAULT_MESSAGE_ADD, response));
    }
}

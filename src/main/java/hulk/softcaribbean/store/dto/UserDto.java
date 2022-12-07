package hulk.softcaribbean.store.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDto {
    private long id;
    private String nameUser;
    private String email;
    private String password;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;
}

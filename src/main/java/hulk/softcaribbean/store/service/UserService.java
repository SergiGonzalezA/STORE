package hulk.softcaribbean.store.service;

import hulk.softcaribbean.store.entity.User;

public interface UserService {

    User findById(long id);

    Boolean existsByUsername(String email);

    User save(User user);
}

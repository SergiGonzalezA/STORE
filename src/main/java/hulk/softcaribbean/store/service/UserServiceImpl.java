package hulk.softcaribbean.store.service;

import hulk.softcaribbean.store.entity.User;
import hulk.softcaribbean.store.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}

package application;

import ports.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String id, String name) {
        User user = new User(id, name);
        userRepository.save(user);
    }

    public User getUser(String id) {
        return userRepository.findById(id);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }
}

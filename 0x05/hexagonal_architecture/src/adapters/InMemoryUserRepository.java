package adapters;

import domain.User;
import ports.UserRepository;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> database = new HashMap<>();

    @Override
    public void save(User user) {
        database.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return database.get(id);
    }

    @Override
    public List<User> findAll() {
        // Uma forma de retornar uma nova lista para evitar modificações externas
        return new ArrayList<>(database.values());

        // Outra forma, usando Streams (Java 8+):
        // return database.values().stream().collect(Collectors.toList());
    }
}

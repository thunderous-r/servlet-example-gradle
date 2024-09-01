package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import lombok.RequiredArgsConstructor;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class UserDAO {
    private final ObjectMapper mapper;
    private final File file;

    public void save(User user) {
        try {
            List<User> users = mapper.readValue(file, new TypeReference<List<User>>() {
            });
            users.add(user);
            mapper.writeValue(file, users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            users = mapper.readValue(file, new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}

package dao;

import com.zaxxer.hikari.HikariDataSource;
import entity.User;
import lombok.RequiredArgsConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UserDAO {
    private final HikariDataSource dataSource;

    public void save(User user) {
        String sql = "insert into users (UUID, login, password) values (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUuid().toString());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving user to database", e);
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "select uuid, login, password from users";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = User.builder()
                        .uuid(UUID.fromString(resultSet.getString("UUID")))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .build();
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all users from database", e);
        }

        return users;
    }

}

package dao;

import com.zaxxer.hikari.HikariDataSource;
import entity.Product;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ProductDAO {
    private final HikariDataSource dataSource;

    public void save(Product product) {

        String sql = "insert into products (img_src, name, owner_uuid) values (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getImgSrc());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getOwnerId().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving product to database", e);
        }
    }

    public ArrayList<Product> getUserProducts(String uuid) {

        ArrayList<Product> products = new ArrayList<>();

        String sql = "select * from products where owner_uuid = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = Product.builder()
                        .id(resultSet.getInt("id"))
                        .imgSrc(resultSet.getString("img_src"))
                        .name(resultSet.getString("name"))
                        .ownerId(UUID.fromString(resultSet.getString("owner_uuid")))
                        .build();
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all products from database", e);
        }
        return products;
    }

    //TODO: add delete method
}

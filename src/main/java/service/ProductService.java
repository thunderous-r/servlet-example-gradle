package service;

import dao.ProductDAO;
import entity.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;
    public void save(Product product) {
        productDAO.save(product);
    }

    public List<Product> getAllProducts(String uuid) {
        return productDAO.getAllProducts(uuid);
    }
}

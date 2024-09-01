package service;

import dao.ProductDAO;
import entity.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;
    public void save(Product product) {
        productDAO.save(product);
    }
}

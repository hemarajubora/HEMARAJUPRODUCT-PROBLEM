package com.example.nxttrendz1.repository;

import java.util.ArrayList;
import com.example.nxttrendz1.model.Product;

public interface ProductRepository {
    ArrayList<Product> getAllProducts();

    Product addProduct(Product product);

    Product getProduct(int productId);

    Product updateProduct(int productId, Product product);

    void deleteProduct(int productId);
}

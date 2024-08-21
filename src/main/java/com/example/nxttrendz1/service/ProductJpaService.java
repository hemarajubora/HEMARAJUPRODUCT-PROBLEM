package com.example.nxttrendz1.service;

import com.example.nxttrendz1.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxttrendz1.model.*;

@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Product> getAllProducts() {
        List<Product> k = productJpaRepository.findAll();
        ArrayList<Product> ar = new ArrayList<>(k);
        return ar;
    }

    @Override
    public Product addProduct(Product product) {
        productJpaRepository.save(product);
        return product;
    }

    @Override
    public Product getProduct(int productId) {
        try {
            Product z = productJpaRepository.findById(productId).get();
            return z;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        try {
            Product x = productJpaRepository.findById(productId).get();
            if (product.getProductName() != null) {
                x.setProductName(product.getProductName());
            }
            if (product.getPrice() != 0.0) {
                x.setPrice(product.getPrice());
            }
            productJpaRepository.save(x);
            return x;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteProduct(int productId) {
        try {
            productJpaRepository.deleteById(productId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

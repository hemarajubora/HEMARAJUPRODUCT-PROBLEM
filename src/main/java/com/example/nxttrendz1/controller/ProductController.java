package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.service.*;

@RestController
public class ProductController {
    @Autowired
    public ProductJpaService productJpaService;

    @GetMapping("/products")
    public ArrayList<Product> getAllProducts() {
        return productJpaService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productJpaService.addProduct(product);
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") int productId) {
        return productJpaService.getProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return productJpaService.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        productJpaService.deleteProduct(productId);
    }
}
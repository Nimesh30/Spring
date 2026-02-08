package com.spring.webApp.service;

import com.spring.webApp.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class productService {
    List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(101, "Redmi", 30000),
                new Product(102, "Google", 80000),
                new Product(103, "BlackBerry", 70000)));

    //Get All Products
    public List<Product> getAllProducts() {
        return products;
    }
    // Get product By ID
    public Product getOneProduct(int id) {
        return products.stream().filter(p -> p.getPId() == id).findFirst().orElse(new  Product(0, "No Product Found", 0));
    }

    // Add product
    public void addProduct(Product prod) {
         products.add(prod);
    }


    public void updateProduct( int id,Product prod) {
        for (int i = 0; i < products.size() ; i++) {
            if (products.get(i).getPId() == id) {
                prod.setPId(id);
                products.set(i,prod);
            }

        }
        throw new RuntimeException("Product not found");
    }
}

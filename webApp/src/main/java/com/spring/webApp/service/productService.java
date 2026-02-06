package com.spring.webApp.service;

import com.spring.webApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class productService {
    List<Product> products = Arrays.asList(
                new Product(101, "Redmi", 30000),
                new Product(102, "Google", 80000),
                new Product(103, "BlackBerry", 70000));

    public List<Product> getAllProducts() {
//        System.out.println("getproducts...Hello" + products.size());
        return products;
    }

    public Product getOneProduct(int id) {
        return products.stream().filter(p ->p.getPId() == id ).findFirst().orElseThrow();
    }
}

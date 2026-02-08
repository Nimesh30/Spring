
// Accepts the request for the products.....

package com.spring.webApp.controller;

import com.spring.webApp.model.Product;
import com.spring.webApp.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {
    @Autowired
    productService service;
    @GetMapping("/products")
     public List<Product> getProdaucts(){
        System.out.println(" from all products controller");
         return service.getAllProducts();
     }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getOneProduct(id);
    }

    @PostMapping("/products")
    public void addProduct( @RequestBody Product prod) {
        service.addProduct(prod);
    }

    @PutMapping("products/{id}")
    public void updateProduct(@PathVariable int id,@RequestBody Product prod) {
//        System.out.println("from update product controller");
        service.updateProduct(id,prod);
    }
}

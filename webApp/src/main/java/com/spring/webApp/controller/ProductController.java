
// Accepts the request for the products.....

package com.spring.webApp.controller;

import com.spring.webApp.model.Product;
import com.spring.webApp.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController {
    @Autowired
    productService service;
    @RequestMapping("/products")
     public List<Product> getProdaucts(){
        System.out.println(" from all products controller");
         return service.getAllProducts();
     }

    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getOneProduct(id);
    }
}

package com.spring.webApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int pId;
    private String productName;
    private int productPrice;

}

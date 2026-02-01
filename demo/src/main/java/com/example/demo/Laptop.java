package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Laptop {

    @RequestMapping("/")
    public String sayBy() {
        System.out.println("from by class bbb");
//        sayHello();
        return "from by class";
    }

//    @RequestMapping("/")
//    public void sayHello() {
//        System.out.println("from say class");
//    }


}

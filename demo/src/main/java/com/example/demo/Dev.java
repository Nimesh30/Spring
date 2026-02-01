package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {
//    Hello hello = new Hello();
//    String str = hello.sayBy();


    @Autowired
    private Laptop laptop;

    public void test(){
        System.out.println("From test");
        String s =laptop.sayBy();
//        laptop.sayHello();
        System.out.println("From test"+ s);

    }

}

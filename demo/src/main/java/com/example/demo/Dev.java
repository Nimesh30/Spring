package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Dev {
//    Hello hello = new Hello();
//    String str = hello.sayBy();


    @Autowired
    private Hello hello;

    public void test(){
        hello.sayBy();
        hello.sayHello();
    }

}

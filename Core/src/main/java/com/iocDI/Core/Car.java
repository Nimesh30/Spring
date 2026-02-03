package com.iocDI.Core;

import org.springframework.stereotype.Component;
//@Component // This is Spring Boot - Annotations
public class Car {

    Engine engine;
    private int age;

    // This will not execute Bcoz Spring uses ONLY ONE constructor per bean creation.
//    public Car() {
//        System.out.println("Default Car Constructor");
//    }

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("Car Constructor...");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void drive(){
        engine.start();
        System.out.println("Car is moving...");
    }
}

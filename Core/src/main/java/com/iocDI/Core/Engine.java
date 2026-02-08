package com.iocDI.Core;

import org.springframework.stereotype.Component;

//@Component // This is Spring Boot - Annotations
public class Engine {
    public Engine() {
        System.out.println("Engine Constructor...");
    }

    public void start() {
        System.out.println("Engine start");
    }
}

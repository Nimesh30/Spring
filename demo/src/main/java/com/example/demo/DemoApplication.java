package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.accept.DefaultApiVersionStrategy;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		System.out.println("From Main Application");
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		Laptop l = context.getBean(Laptop.class);
	//	System.out.println("From Main Application 2");
		Dev dev = context.getBean(Dev.class);
		dev.test();
		//Hello hello=new Hello();

	}

}

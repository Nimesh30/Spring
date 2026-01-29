package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		System.out.println("From Main Application");
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	//	Hello hello = context.getBean(Hello.class);
	//	System.out.println("From Main Application 2");

		//Hello hello=new Hello();

	}

}

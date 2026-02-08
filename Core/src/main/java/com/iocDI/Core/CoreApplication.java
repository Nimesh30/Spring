package com.iocDI.Core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication // Spring boot Annotations
public class CoreApplication {

	public static void main(String[] args) {

//ApplicationContext context = SpringApplication.run(CoreApplication.class, args); //Spring Boot auto configuration
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); // Spring XML Based
//		Car car = context.getBean(Car.class);
		Car car = (Car) context.getBean("car");
		car.drive();
		car.setAge(18);
		System.out.println(car.getAge());
	}
} 

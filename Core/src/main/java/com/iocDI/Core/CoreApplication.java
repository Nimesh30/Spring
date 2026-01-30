package com.iocDI.Core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CoreApplication.class, args);
		Car car = context.getBean(Car.class);
		car.drive();
	}


}

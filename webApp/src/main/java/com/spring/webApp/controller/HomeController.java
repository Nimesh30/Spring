package com.spring.webApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
//    @ResponseBody - will Return whole body of page - We can use instead of @RestController
    public String greet(){
        System.out.println("Hello World from terminal....");
        return "Hello World!";
    }
//    @ResponseBody
    @RequestMapping("/about")
    public String about(){
        System.out.println("Hello World from terminal....");
        return "You are in about page..";
    }
}

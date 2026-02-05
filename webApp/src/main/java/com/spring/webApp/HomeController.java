package com.spring.webApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
//    @ResponseBody - will Return whole body of page - We can use instead of @RestController
    public String greet(){
        System.out.println("Hello World from terminal....");
        return "Hello World!";
    }
}

package com.example.firstspringproject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class print {

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/sayHellom/{message}")
    public String sayHellom(@PathVariable("message") String message) {
        return "Hello World" + message;
    }

}

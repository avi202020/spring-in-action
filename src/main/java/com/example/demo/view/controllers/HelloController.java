package com.example.demo.view.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class HelloController {

    @GetMapping("/")
    public @ResponseBody String home(){
        return "Hello";
    }

}

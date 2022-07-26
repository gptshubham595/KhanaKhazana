package com.khana.khazana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/home")
    public String home(){
        return "Khana khalo friends";
    }
}

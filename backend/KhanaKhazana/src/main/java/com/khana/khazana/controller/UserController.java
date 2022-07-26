package com.khana.khazana.controller;

import com.khana.khazana.model.SignUpResponse;
import com.khana.khazana.model.Users;
import com.khana.khazana.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;
    public ResponseEntity<SignUpResponse> signUp(@RequestBody Users user){

        if(user.getRole()==null || user.getRole().equals("customer")){
            SignUpResponse signUpResponse = userService.registerCustomer(user);
            return new ResponseEntity<>(signUpResponse, HttpStatus.OK);
        }
        else if(user.getRole().equals("restaurant")){
            SignUpResponse signUpResponse = userService.registerRestaurant(user);
            return new ResponseEntity<>(signUpResponse, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

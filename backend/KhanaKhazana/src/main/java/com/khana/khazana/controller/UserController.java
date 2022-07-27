package com.khana.khazana.controller;

import com.khana.khazana.model.LoginRequest;
import com.khana.khazana.model.LoginResponse;
import com.khana.khazana.model.SignUpResponse;
import com.khana.khazana.model.Users;
import com.khana.khazana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping(value="/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        try{
            LoginResponse loginResponse = userService.authenticate(loginRequest);
            if (loginResponse.isStatus()) {
                return new ResponseEntity<>(loginResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            LoginResponse loginResponse = null ;
            return new ResponseEntity<>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value="/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody Users user){

        if(user.getRole()==null || user.getRole().equals("customer") || user.getRole().equals("restaurant")){
            SignUpResponse signUpResponse = userService.Register(user);
            return new ResponseEntity<>(signUpResponse, HttpStatus.OK);
        }
        else{
            SignUpResponse signUpResponse = new SignUpResponse();
            signUpResponse.setStatus(false);
            signUpResponse.setMessage("Invalid role");
            return new ResponseEntity<>(signUpResponse,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/logout",consumes = "application/json", produces = "application/json")
    public void Logout(){
        userService.Logout();
    }

}

package com.khana.khazana.controller;

import com.khana.khazana.model.*;
import com.khana.khazana.repository.UserRepository;
import com.khana.khazana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse loginResponse = userService.authenticate(loginRequest);
            if (loginResponse.isStatus()) {
                return new ResponseEntity<>(loginResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            LoginResponse loginResponse = null;
            return new ResponseEntity<>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody Users user) {

        if (user.getRole() == null || user.getRole().equals("customer") || user.getRole().equals("manager")) {
            SignUpResponse signUpResponse = userService.Register(user);
            return new ResponseEntity<>(signUpResponse, HttpStatus.OK);
        } else {
            SignUpResponse signUpResponse = new SignUpResponse();
            signUpResponse.setStatus(false);
            signUpResponse.setMessage("Invalid role");
            return new ResponseEntity<>(signUpResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/help")
    public ResponseEntity<Help> getHelp() {
        Help help = new Help();
        help.setContactName("RAJ MALHOTRA");
        help.setContactPhone("1800-123-3600");
        help.setContactAddress("MUMBAI");
        help.setContactCompany("KhanaKhazana");
        return new ResponseEntity<>(help, HttpStatus.OK);
    }
    @PostMapping(value = "/logout", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DefaultResponse> Logout(@RequestBody WhichUserRequest whichUserRequest) {
        DefaultResponse defaultResponse = userService.Logout(whichUserRequest);
        if(defaultResponse.isStatus()){
            return new ResponseEntity<>(defaultResponse, HttpStatus.OK);
        }

        return  new ResponseEntity<>(defaultResponse, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/currRole", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CurrentUserResponse> currentRole(@RequestBody WhichUserRequest whichUserRequest) {
        if (whichUserRequest == null)
            return new ResponseEntity<>(new CurrentUserResponse(), HttpStatus.BAD_REQUEST);
        CurrentUserResponse currentUserResponse = userService.currentUser(whichUserRequest);
        if (!currentUserResponse.isStatus())
            return new ResponseEntity<>(currentUserResponse, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(currentUserResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/isLoggedIn", consumes = "application/json", produces = "application/json")
    public ResponseEntity<WhichUserResponse> isLoggedIn(@RequestBody WhichUserRequest whichUserRequest) {
        WhichUserResponse whichUserResponse = userService.isLoggedIn(whichUserRequest);
        if (!whichUserResponse.isStatus())
            return new ResponseEntity<>(whichUserResponse, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(whichUserResponse, HttpStatus.OK);
    }

}

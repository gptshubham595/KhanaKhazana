package com.khana.khazana.controller;

import com.khana.khazana.model.ProfileResponse;
import com.khana.khazana.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    private boolean isLoggedIn = false;
    private String currRole = "customer";

    @PostMapping(value = "/profile",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ProfileResponse> getProfileData(@RequestBody String  userid){
        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setUsername(userid);
        return new ResponseEntity<>(profileResponse, HttpStatus.OK);
    }
}

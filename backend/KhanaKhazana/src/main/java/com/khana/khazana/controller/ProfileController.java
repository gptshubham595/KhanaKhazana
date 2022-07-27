package com.khana.khazana.controller;

import com.khana.khazana.model.ProfileRequest;
import com.khana.khazana.model.ProfileResponse;
import com.khana.khazana.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping(value = "/profile", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ProfileResponse> getProfileData(@RequestBody ProfileRequest profileRequest) {
        ProfileResponse profileResponse = profileService.getProfileData(profileRequest);
        if (profileResponse.isFlag()) {
            return new ResponseEntity<>(profileResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(profileResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

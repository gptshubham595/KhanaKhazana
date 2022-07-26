package com.khana.khazana.controller;

import com.khana.khazana.model.ProfileResponse;
import com.khana.khazana.model.Users;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.khana.khazana.service.UserService.isLoggedIn;


@RestController
public class ProfileController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/profile",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ProfileResponse> getProfileData(@RequestBody Long userId){
        ProfileResponse profileResponse = new ProfileResponse();
        if(userId==null){
            return new ResponseEntity<>(profileResponse,HttpStatus.BAD_REQUEST);
        }
        Users userData=userRepository.findByUserId(userId);
        if(userData!=null){
            profileResponse.setUsername(userData.getUsername());
            profileResponse.setEmail(userData.getEmail());
            profileResponse.setMobile(userData.getMobile());
            profileResponse.setAddress(userData.getAddress());
            profileResponse.setUserPic(userData.getProfilePic());

            profileResponse.setFlag(true);
            profileResponse.setMessage("Profile Fetched Successfully");
        }else{
            profileResponse=null;
        }
        return new ResponseEntity<>(profileResponse, HttpStatus.OK);
    }
}

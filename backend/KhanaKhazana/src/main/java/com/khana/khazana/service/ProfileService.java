package com.khana.khazana.service;

import com.khana.khazana.model.*;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.khana.khazana.service.UserService.isLoggedIn;

@Service
public class ProfileService {
    @Autowired
    UserRepository userRepository;

    public ProfileResponse getProfileData(WhichUserRequest whichUserRequest) {
        WhichUserResponse whichUserResponse = isLoggedIn(whichUserRequest);
        Users userData = userRepository.findByUserId(whichUserRequest.getUserId());
      
        ProfileResponse profileResponse = new ProfileResponse();

        if(!whichUserResponse.isStatus()){
            profileResponse.setFlag(false);
            profileResponse.setMessage("INVALID USER");
            return profileResponse;
        }
        if(whichUserResponse.isStatus() && userData!=null){
            profileResponse.setUsername(userData.getUsername());
            profileResponse.setEmail(userData.getEmail());
            profileResponse.setMobile(userData.getMobile());
            profileResponse.setAddress(userData.getAddress());
            profileResponse.setUserPic(userData.getProfilePic());

            profileResponse.setFlag(true);
            profileResponse.setMessage("Profile Fetched Successfully");
            profileResponse.setRole(userData.getRole());
        }else {
            profileResponse.setFlag(false);
            profileResponse.setMessage("Profile Fetching  Unsuccessfull");
        }

        return profileResponse;
    }
}

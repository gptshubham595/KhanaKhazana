package com.khana.khazana.service;

import com.khana.khazana.model.ProfileRequest;
import com.khana.khazana.model.ProfileResponse;
import com.khana.khazana.model.Users;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    UserRepository userRepository;

    public ProfileResponse getProfileData(ProfileRequest profileRequest) {
        ProfileResponse profileResponse = new ProfileResponse();
        if (profileRequest.getUserId()== null) {
            profileResponse.setFlag(false);
            profileResponse.setMessage("INVALID USER");
            return profileResponse;
        }
        Users userData = userRepository.findByUserId(profileRequest.getUserId());
        if (userData != null) {
            profileResponse.setUsername(userData.getUsername());
            profileResponse.setEmail(userData.getEmail());
            profileResponse.setMobile(userData.getMobile());
            profileResponse.setAddress(userData.getAddress());
            profileResponse.setUserPic(userData.getProfilePic());

            profileResponse.setFlag(true);
            profileResponse.setMessage("Profile Fetched Successfully");
        } else {
            profileResponse.setFlag(false);
            profileResponse.setMessage("Profile Fetching  Unsuccessfull");
        }
        return profileResponse;
    }
}

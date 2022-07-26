package com.khana.khazana.service;

import com.khana.khazana.model.SignUpResponse;
import com.khana.khazana.model.Users;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public SignUpResponse registerCustomer(Users user){
        Users currentUser =userRepository.findByEmail(user.getEmail());
        SignUpResponse signUpResponse = new SignUpResponse();

        if(currentUser != null){
            signUpResponse.setStatus(false);
            signUpResponse.setMessage("User already exists");
            return signUpResponse;
        }
        else{
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
            user.setPassword(hashedPassword);
            user.setRole("customer");
            userRepository.save(user);
            signUpResponse.setStatus(true);
            signUpResponse.setMessage("Customer Registration successful. ");
            return signUpResponse;
        }
    }

    public SignUpResponse registerRestaurant(Users user){
        Users currentUser =userRepository.findByEmail(user.getEmail());
        SignUpResponse signUpResponse = new SignUpResponse();

        if(currentUser != null){
            signUpResponse.setStatus(false);
            signUpResponse.setMessage("Restaurant Manager already exists");
            return signUpResponse;
        }
        else{
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
            user.setPassword(hashedPassword);
            user.setRole("restaurant");
            userRepository.save(user);
            signUpResponse.setStatus(true);
            signUpResponse.setMessage("Restaurant Registration successful.");
            return signUpResponse;
        }
    }
}

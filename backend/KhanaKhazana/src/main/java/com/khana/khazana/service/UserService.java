package com.khana.khazana.service;

import com.khana.khazana.model.LoginRequest;
import com.khana.khazana.model.LoginResponse;
import com.khana.khazana.model.SessionToken;
import com.khana.khazana.model.SignUpResponse;
import com.khana.khazana.model.Users;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
    
    public static HashMap<Long,HashMap<SessionToken,HashMap<String,Boolean>>> userIdTokenRoleisLoggedIn;
//    public static  HashMap<Long,String> currRole;

    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    public LoginResponse authenticate(LoginRequest loginRequest){
        Users user = userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        if(user == null){
            loginResponse.setStatus(false);
            loginResponse.setMessage("User not found");
        }
        else if((BCrypt.hashpw(loginRequest.getPassword(), user.getSalt())).equals(user.getPassword())){
            loginResponse.setStatus(true);
            loginResponse.setMessage("Login Successful");
            currRole = user.getRole();
            isLoggedIn = true;
        }
        else{
            loginResponse.setStatus(false);
            loginResponse.setMessage("Invalid Password"+BCrypt.hashpw(loginRequest.getPassword(), user.getSalt()));
        }

        return loginResponse;
    }


    public SignUpResponse Register(Users user){
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
            user.setSalt(salt);
            userRepository.save(user);
            signUpResponse.setStatus(true);
            signUpResponse.setMessage("Registration successful.");
            return signUpResponse;
        }
    }

    public void Logout(){
        isLoggedIn = false;
    }
}


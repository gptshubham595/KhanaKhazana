package com.khana.khazana.service;

import com.khana.khazana.model.*;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    // public static HashMap<Long,String> currRole;
    @Value("${pepper}")
    String pepper;
    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    private static HashMap<Long, HashMap<String, HashMap<Users, Boolean>>> userIdTokenRoleisLoggedIn;


    public void removeLoggedInUser(Long userId) {
        try {
            userIdTokenRoleisLoggedIn.remove(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveLoggedInUser(Users user, String token) {
        removeLoggedInUser(user.getUserId());
        HashMap<Users, Boolean> RoleisLoggedIn = new HashMap<>();

        RoleisLoggedIn.put(user, true);
        HashMap<String, HashMap<Users, Boolean>> TokenRoleisLoggedIn = new HashMap<>();
        TokenRoleisLoggedIn.put(token, RoleisLoggedIn);
        userIdTokenRoleisLoggedIn.put(user.getUserId(), TokenRoleisLoggedIn);
    }

    public static WhichUserResponse isLoggedIn(WhichUserRequest whichUserRequest){
        WhichUserResponse whichUserResponse = new WhichUserResponse();
        if(userIdTokenRoleisLoggedIn == null){
            whichUserResponse.setStatus(false);
            whichUserResponse.setMessage("user is not logged in");
            return whichUserResponse;
        }
        HashMap.Entry<String, HashMap<Users, Boolean>> entry = userIdTokenRoleisLoggedIn.get(whichUserRequest.getUserId()).entrySet().iterator().next();
        String token = entry.getKey();
        if(token.equals(whichUserRequest.getToken())){
            HashMap<Users, Boolean> roleIsLoggedIn = entry.getValue();
//            String role  = roleIsLoggedIn.entrySet().iterator().next().getKey().getRole();
            if(roleIsLoggedIn.entrySet().iterator().next().getValue() == null){
                whichUserResponse.setStatus(false);
                whichUserResponse.setMessage("user is not logged in");
            }
            whichUserResponse.setStatus(roleIsLoggedIn.entrySet().iterator().next().getValue());
            if(roleIsLoggedIn.entrySet().iterator().next().getValue())
                whichUserResponse.setMessage("user is logged in");
            else
                whichUserResponse.setMessage("user is not logged in");
        }else {
            whichUserResponse.setStatus(false);
            whichUserResponse.setMessage("invalid token");
        }
        return whichUserResponse;
    }

    public static CurrentUserResponse currentUser(WhichUserRequest whichUserRequest){
        WhichUserResponse whichUserResponse = isLoggedIn(whichUserRequest);
        CurrentUserResponse currentUserResponse = new CurrentUserResponse();

        if(!whichUserResponse.isStatus()){
            currentUserResponse.setRole("customer");
            currentUserResponse.setToken(null);
            currentUserResponse.setStatus(false);
            currentUserResponse.setMessage("user is not logged in ");
            return currentUserResponse;
        }

        HashMap.Entry<String, HashMap<Users, Boolean>> entry = userIdTokenRoleisLoggedIn.get(whichUserRequest.getUserId()).entrySet().iterator().next();
        String token = entry.getKey();
        HashMap<Users, Boolean> roleIsLoggedIn = entry.getValue();
        String role = roleIsLoggedIn.entrySet().iterator().next().getKey().getRole();

        currentUserResponse.setRole(role);
        currentUserResponse.setToken(token);
        currentUserResponse.setStatus(true);
        currentUserResponse.setMessage("user is logged in ");

        return currentUserResponse;
    }

    public LoginResponse authenticate(LoginRequest loginRequest) {

        userIdTokenRoleisLoggedIn = new HashMap<>();
        LoginResponse loginResponse = new LoginResponse();

        Users user = userRepository.findByEmail(loginRequest.getEmail());
        if (userIdTokenRoleisLoggedIn.containsKey(user.getUserId())) {
            loginResponse.setStatus(false);
            loginResponse.setToken(null);
            loginResponse.setRole("customer");
            loginResponse.setMessage("Logout first!");
            return loginResponse;
        }
        if (user == null) {
            loginResponse.setStatus(false);
            loginResponse.setToken(null);
            loginResponse.setRole("customer");
            loginResponse.setMessage("User not found");
        } else if ((BCrypt.hashpw(loginRequest.getPassword(), user.getSalt())).equals(user.getPassword())) {
            loginResponse.setStatus(true);
            loginResponse.setMessage("Login Successful");
            String token = BCrypt.gensalt();
            loginResponse.setToken(token);
            loginResponse.setRole(user.getRole());

            saveLoggedInUser(user, token);
        } else {
            loginResponse.setStatus(false);
            loginResponse.setMessage("Invalid Password" + BCrypt.hashpw(loginRequest.getPassword(), user.getSalt()));
        }

        return loginResponse;
    }

    public SignUpResponse Register(Users user) {
        Users currentUser = userRepository.findByEmail(user.getEmail());
        SignUpResponse signUpResponse = new SignUpResponse();

        if (currentUser != null) {
            signUpResponse.setStatus(false);
            signUpResponse.setMessage("User already exists");
            return signUpResponse;
        } else {
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
            user.setPassword(hashedPassword);
            user.setSalt(salt);
            String role = "customer";
            if (user.getRole() == null) {
                role = "customer";
            }else if (user.getRole().equals("admin")) {
                role = "customer";
            }else if(!user.getRole().equals("customer") && !user.getRole().equals("manager")) {
                role="customer";
            }else{
                role=user.getRole();
            }

            user.setRole(role);

            userRepository.save(user);
            signUpResponse.setStatus(true);
            signUpResponse.setMessage("Registration successful.");
            return signUpResponse;
        }
    }

    public void Logout(Long userId) {
        removeLoggedInUser(userId);
    }
}

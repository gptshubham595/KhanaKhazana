package com.khana.khazana.controller;

import com.khana.khazana.model.BanUserResponse;
import com.khana.khazana.model.ShowAllUsersResponse;
import com.khana.khazana.model.*;
import com.khana.khazana.repository.UserRepository;
import com.khana.khazana.service.AdminService;
import com.khana.khazana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.khana.khazana.service.UserService.currentUser;
import static com.khana.khazana.service.UserService.isLoggedIn;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    UserRepository userRepository;
    public boolean AdminExistsInDB(long userId){
        Users user = userRepository.findByUserId(userId);
        if(user==null || !user.getRole().equals("admin")){
            return false;
        }

        return true;
    }

    @PostMapping(value = "/showAllCustomer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ShowAllUsersResponse> DisplayAllUsers(@RequestBody WhichUserRequest whichUserRequest){

        boolean adminExistsInDB = AdminExistsInDB(whichUserRequest.getUserId());
        WhichUserResponse tokenMatch = isLoggedIn(whichUserRequest);
        CurrentUserResponse currentUserResponse;
        currentUserResponse = currentUser(whichUserRequest);
        if(currentUserResponse.getRole().equals("admin") && adminExistsInDB && tokenMatch.isStatus()){
            return new ResponseEntity<>(adminService.AllCustomer(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/showAllManager", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ShowAllUsersResponse> DisplayAllManagers(@RequestBody WhichUserRequest whichUserRequest){
        boolean adminExistsInDB = AdminExistsInDB(whichUserRequest.getUserId());
        WhichUserResponse tokenMatch = isLoggedIn(whichUserRequest);
        CurrentUserResponse currentUserResponse;
        currentUserResponse = currentUser(whichUserRequest);
        if(currentUserResponse.getRole().equals("admin") && adminExistsInDB && tokenMatch.isStatus()){
            return new ResponseEntity<>(adminService.AllManager(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/showAllRestaurant", consumes = "application/json", produces = "application/json")
    public ResponseEntity<FetchRestaurantResponse> DisplayAllRestaurants(@RequestBody WhichUserRequest whichUserRequest) {
        boolean adminExistsInDB = AdminExistsInDB(whichUserRequest.getUserId());
        WhichUserResponse tokenMatch = isLoggedIn(whichUserRequest);
        CurrentUserResponse currentUserResponse;
        currentUserResponse = currentUser(whichUserRequest);
        if(currentUserResponse.getRole().equals("admin") && adminExistsInDB && tokenMatch.isStatus()){
            return new ResponseEntity<>(adminService.AllRestaurant(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    // @GetMapping(value = "/showOrders/userId={}")
    // public ResponseEntity<ShowAllCustomerResponse> DisplayOrders(){
    // return new ResponseEntity<>(adminService.AllOrders(), HttpStatus.OK)
    // }

    @PostMapping(value = "/manageUser/ban", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BanUserResponse> BanUser(@RequestBody BanUserRequest banUserRequest) {
        CurrentUserResponse currentUserResponse;
        WhichUserRequest whichUserRequest = new WhichUserRequest();
        whichUserRequest.setUserId(banUserRequest.getAdminId());
        whichUserRequest.setToken(banUserRequest.getToken());
        boolean adminExistsInDB = AdminExistsInDB(whichUserRequest.getUserId());
        WhichUserResponse tokenMatch = isLoggedIn(whichUserRequest);
        currentUserResponse = currentUser(whichUserRequest);

        if(currentUserResponse.getRole().equals("admin") && adminExistsInDB && tokenMatch.isStatus()){
            return new ResponseEntity<>(adminService.banUser(banUserRequest.getCustomerId()), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}

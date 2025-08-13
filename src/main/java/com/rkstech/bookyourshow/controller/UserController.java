package com.rkstech.bookyourshow.controller;

import com.rkstech.bookyourshow.dtos.CreateUserRequest;
import com.rkstech.bookyourshow.dtos.GetUserResponse;
import com.rkstech.bookyourshow.models.User;
import com.rkstech.bookyourshow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    UserService userService;
//    shortcut for below @PostMapping("/user")
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public GetUserResponse createUser(@RequestBody CreateUserRequest userRequest){  // Request body will validate the data and format with all fields are present With the validation that we have done in our CreateUserRequest like @NotNull
        System.out.println("Got request for :"+ userRequest.getEmail());

        User user = userService.createUser(userRequest.toUser());
        return GetUserResponse.fromUser(user);
    }
}

//create a user -> POST /api/v1/user
//fetch a user -> GET /api/v1/user/:id
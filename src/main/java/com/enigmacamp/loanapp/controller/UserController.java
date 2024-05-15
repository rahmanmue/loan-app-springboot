package com.enigmacamp.loanapp.controller;

import com.enigmacamp.loanapp.model.entity.User;
import com.enigmacamp.loanapp.model.response.CommonResponse;
import com.enigmacamp.loanapp.model.response.UserResponse;
import com.enigmacamp.loanapp.service.UserService;
import com.enigmacamp.loanapp.utils.constant.ApiPathConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPathConstant.API+ApiPathConstant.USERS)
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    ResponseEntity<CommonResponse<UserResponse>> getUserById(@PathVariable String id){
        UserResponse userResponse = userService.getUserById(id);
        CommonResponse<UserResponse> commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Success get user by id");
        commonResponse.setData(userResponse);
        return ResponseEntity.status(HttpStatus.OK).body(commonResponse);
    }
}

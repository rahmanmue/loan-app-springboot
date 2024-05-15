package com.enigmacamp.loanapp.controller;

import com.enigmacamp.loanapp.model.request.AuthRequest;
import com.enigmacamp.loanapp.model.response.CommonResponse;
import com.enigmacamp.loanapp.model.response.SigninResponse;
import com.enigmacamp.loanapp.model.response.SignupResponse;
import com.enigmacamp.loanapp.service.AuthService;
import com.enigmacamp.loanapp.utils.constant.ApiPathConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPathConstant.API + ApiPathConstant.AUTH)
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("signup")
    public ResponseEntity<CommonResponse<SignupResponse>> register(@RequestBody AuthRequest authRequest){
        CommonResponse<SignupResponse> commonResponse = new CommonResponse<>();
        authRequest.setRole("ROLE_ADMIN");
        SignupResponse result = authService.signUp(authRequest);
        commonResponse.setMessage("Success Register");
        commonResponse.setData(result);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(commonResponse);
    }

    @PostMapping("signup-customer")
    public ResponseEntity<CommonResponse<SignupResponse>> registerCustomer(@RequestBody AuthRequest authRequest){
        CommonResponse<SignupResponse> commonResponse = new CommonResponse<>();
        authRequest.setRole("ROLE_CUSTOMER");
        SignupResponse result = authService.signUp(authRequest);
        commonResponse.setMessage("Success Register");
        commonResponse.setData(result);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(commonResponse);
    }

    @PostMapping("signin")
    public ResponseEntity<CommonResponse<SigninResponse>> login (@RequestBody AuthRequest authRequest){
        SigninResponse signinResponse = authService.signIn(authRequest);
        CommonResponse<SigninResponse> response = CommonResponse.<SigninResponse>builder()
                .message("Success Login")
                .data(signinResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}

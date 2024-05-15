package com.enigmacamp.loanapp.service;

import com.enigmacamp.loanapp.model.request.AuthRequest;
import com.enigmacamp.loanapp.model.response.SigninResponse;
import com.enigmacamp.loanapp.model.response.SignupResponse;

public interface AuthService {
    SignupResponse signUp (AuthRequest authRequest);
    SigninResponse signIn(AuthRequest authRequest);
}

package com.enigmacamp.loanapp.service.impl;

import com.enigmacamp.loanapp.model.entity.AppUser;
import com.enigmacamp.loanapp.model.entity.Customer;
import com.enigmacamp.loanapp.model.entity.Role;
import com.enigmacamp.loanapp.model.entity.User;
import com.enigmacamp.loanapp.model.request.AuthRequest;
import com.enigmacamp.loanapp.model.response.SigninResponse;
import com.enigmacamp.loanapp.model.response.SignupResponse;
import com.enigmacamp.loanapp.repository.UserRepository;
import com.enigmacamp.loanapp.security.JwtUtil;
import com.enigmacamp.loanapp.service.AuthService;
import com.enigmacamp.loanapp.service.CustomerService;
import com.enigmacamp.loanapp.service.RoleService;
import com.enigmacamp.loanapp.utils.constant.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RoleService roleService;

    private final CustomerService customerService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    @Override
    public SignupResponse signUp(AuthRequest authRequest) {
        try {
            // 1. set role
            List<Role> roles = new ArrayList<>();
            List<ERole> erole = new ArrayList<>();
            if(authRequest.getRole().equals("ROLE_CUSTOMER")){
                roles.add(roleService.getOrSave(ERole.ROLE_CUSTOMER));
                erole.add(ERole.ROLE_CUSTOMER);
            } else if (authRequest.getRole().equals("ROLE_ADMIN")) {
                for(ERole role : ERole.values()){
                    if(!role.name().equals("ROLE_CUSTOMER")){
                        roles.add(roleService.getOrSave(role));
                        erole.add(role);
                    }
                }
            }



            // 2. set credential/user
            User user = User.builder()
                    .email(authRequest.getEmail())
                    .password(passwordEncoder.encode(authRequest.getPassword()))
                    .roles(roles)
                    .build();

            userRepository.save(user);


            // 3. set customer
            Customer customer = new Customer();
            customer.setUser(user);

            customerService.saveCustomer(customer);

            // 4. create response

            return SignupResponse.builder()
                    .email(user.getEmail())
                    .roles(erole)
                    .build();


        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "user already exist");
        }

    }

    @Override
    public SigninResponse signIn(AuthRequest authRequest) {
        try {
            System.out.println(authRequest.getEmail());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(),
                    authRequest.getPassword()
            ));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            AppUser appUser = (AppUser) authentication.getPrincipal();

            System.out.println(appUser);

            String token = jwtUtil.generateToken(appUser);

            return SigninResponse.builder()
                    .token(token)
                    .email(appUser.getEmail())
                    .roles(appUser.getRoles())
                    .build();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}


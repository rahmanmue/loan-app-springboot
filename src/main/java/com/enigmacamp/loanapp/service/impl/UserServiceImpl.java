package com.enigmacamp.loanapp.service.impl;

import com.enigmacamp.loanapp.model.entity.AppUser;
import com.enigmacamp.loanapp.model.entity.Role;
import com.enigmacamp.loanapp.model.entity.User;
import com.enigmacamp.loanapp.model.response.UserResponse;
import com.enigmacamp.loanapp.repository.UserRepository;
import com.enigmacamp.loanapp.service.UserService;
import com.enigmacamp.loanapp.utils.constant.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public AppUser loadUserByUserId(String id) {

        User user = userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("invalid credential user "));
        List<ERole> erole = new ArrayList<>();
        for (Role role : user.getRoles()){
            erole.add(role.getRole());
        }

        return AppUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(erole)
                .build();

    }

    @Override
    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("invalid credential user "));
        List<ERole> erole = new ArrayList<>();
        for (Role role : user.getRoles()){
            erole.add(role.getRole());
        }

        return UserResponse.builder()
                .email(user.getEmail())
                .roles(erole)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("invalid credential user "));
        List<ERole> erole = new ArrayList<>();
        for (Role role : user.getRoles()){
            erole.add(role.getRole());
        }
        return  AppUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(erole)
                .build();
    }


}

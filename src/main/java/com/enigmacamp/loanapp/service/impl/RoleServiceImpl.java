package com.enigmacamp.loanapp.service.impl;

import com.enigmacamp.loanapp.model.entity.Role;
import com.enigmacamp.loanapp.repository.RoleRepository;
import com.enigmacamp.loanapp.service.RoleService;
import com.enigmacamp.loanapp.utils.constant.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role getOrSave(ERole role) {

        Optional<Role> optionalRole = roleRepository.findByRole(role);
        if(optionalRole.isPresent()){
            return optionalRole.get();
        }

        Role currentRole = Role.builder().role(role).build();

        return roleRepository.saveAndFlush(currentRole);
    }
}

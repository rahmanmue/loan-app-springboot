package com.enigmacamp.loanapp.service;

import com.enigmacamp.loanapp.model.entity.Role;
import com.enigmacamp.loanapp.utils.constant.ERole;

public interface RoleService {
    Role getOrSave(ERole role);
}

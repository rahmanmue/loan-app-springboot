package com.enigmacamp.loanapp.model.response;

import com.enigmacamp.loanapp.utils.constant.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private String email;
    private List<ERole> roles;
}

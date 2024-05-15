package com.enigmacamp.loanapp.model.entity;

import com.enigmacamp.loanapp.utils.constant.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_role")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ERole role;
}

package com.enigmacamp.loanapp.model.entity;

import com.enigmacamp.loanapp.utils.constant.EInstalmentType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_instalment_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InstalmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "instalment_type_id")
    private String id;
    @Enumerated(EnumType.STRING)
    private EInstalmentType instalmentType;
}

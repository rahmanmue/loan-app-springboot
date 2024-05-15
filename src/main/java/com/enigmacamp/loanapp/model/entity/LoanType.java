package com.enigmacamp.loanapp.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_loan_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "loan_type_id")
    private String id;
    @Column(name = "maximum_loan")
    private Double maxLoan;
    private String type;
}

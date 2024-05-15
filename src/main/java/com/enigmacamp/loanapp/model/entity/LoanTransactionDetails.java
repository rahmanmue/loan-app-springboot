package com.enigmacamp.loanapp.model.entity;

import com.enigmacamp.loanapp.utils.constant.ELoanStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trx_loan_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoanTransactionDetails {
    @Id
    @Column(name = "loan_detail_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "transaction_date")
    private Long transactionDate;
    private Double nominal;

    @Column(name = "loan_status")
    private ELoanStatus loanStatus;
    @Column(name = "created_at")
    private Long createdAt;
    @Column(name = "updated_at")
    private Long updatedAt;

    // join
    @ManyToOne
    @JoinColumn(name = "loan_id")
    @JsonIgnoreProperties("loanTransactionDetails")
    private LoanTransaction loanTransaction;

}

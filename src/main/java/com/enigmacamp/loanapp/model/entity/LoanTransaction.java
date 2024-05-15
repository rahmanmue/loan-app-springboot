package com.enigmacamp.loanapp.model.entity;

import com.enigmacamp.loanapp.utils.constant.EApprovalStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "trx_loan")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoanTransaction {
    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private Double nominal;
    @Column(name = "approved_at")
    private Long approvedAt;
    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "created_at")
    private Long createdAt;
    @Column(name = "update_at")
    private Long updatedAt;

    @Column(name = "approval_status")
    @Enumerated(EnumType.STRING)
    private EApprovalStatus approvalStatus; // enum


    // join
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "loan_type_id")
    private LoanType loanType;

    @ManyToOne
    @JoinColumn(name = "instalment_type_id")
    private InstalmentType instalmentType;

    @OneToMany(mappedBy = "loanTransaction")
    @JsonIgnoreProperties("loanTransaction")
    private List<LoanTransactionDetails> loanTransactionDetails;
}

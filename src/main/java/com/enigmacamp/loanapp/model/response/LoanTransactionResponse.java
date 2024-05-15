package com.enigmacamp.loanapp.model.response;

import com.enigmacamp.loanapp.model.entity.Customer;
import com.enigmacamp.loanapp.model.entity.InstalmentType;
import com.enigmacamp.loanapp.model.entity.LoanTransactionDetails;
import com.enigmacamp.loanapp.model.entity.LoanType;
import com.enigmacamp.loanapp.utils.constant.EApprovalStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoanTransactionResponse {
    private String id;
    private Double nominal;
    private Long approvedAt;
    private String approvedBy;
    private Long createdAt;
    private Long updatedAt;
    private EApprovalStatus approvalStatus;
    private String loanTypeId;
    private String instalmentTypeId;
    private String customerId;
    private List<LoanTransactionDetails> TransactionDetailResponses;
}

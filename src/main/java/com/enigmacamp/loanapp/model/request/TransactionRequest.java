package com.enigmacamp.loanapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequest {
    private LoanTransactionRequest loanType;
    private InstalmentTransaction instalmentType;
    private CustomerTransaction customer;
    private Double nominal;
}

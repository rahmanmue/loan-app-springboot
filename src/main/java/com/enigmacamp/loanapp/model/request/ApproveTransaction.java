package com.enigmacamp.loanapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApproveTransaction {
    private String loanTransactionId;
    private Double interestRates;
}

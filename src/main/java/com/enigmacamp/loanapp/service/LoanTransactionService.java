package com.enigmacamp.loanapp.service;

import com.enigmacamp.loanapp.model.entity.LoanTransaction;
import com.enigmacamp.loanapp.model.request.ApproveTransaction;
import com.enigmacamp.loanapp.model.request.LoanTransactionRequest;
import com.enigmacamp.loanapp.model.request.TransactionRequest;
import com.enigmacamp.loanapp.model.response.LoanTransactionResponse;

public interface LoanTransactionService {
    LoanTransactionResponse saveLoanTransaction(TransactionRequest TransactionRequest);
    LoanTransaction approveTransactionByAdmin(ApproveTransaction approveTransaction);
}

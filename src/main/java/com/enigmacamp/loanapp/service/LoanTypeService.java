package com.enigmacamp.loanapp.service;

import com.enigmacamp.loanapp.model.entity.LoanType;

import java.util.List;
import java.util.Optional;

public interface LoanTypeService {

    LoanType saveLoanType(LoanType loanType);
    LoanType updateLoanType(LoanType loanType);
    Optional <LoanType> getLoanTypeById(String id);
    List<LoanType> getAllLoanTypes();
    void deleteLoanType(String id);
}

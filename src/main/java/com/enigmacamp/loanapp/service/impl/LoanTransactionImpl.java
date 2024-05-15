package com.enigmacamp.loanapp.service.impl;

import com.enigmacamp.loanapp.model.entity.Customer;
import com.enigmacamp.loanapp.model.entity.InstalmentType;
import com.enigmacamp.loanapp.model.entity.LoanTransaction;
import com.enigmacamp.loanapp.model.entity.LoanType;
import com.enigmacamp.loanapp.model.request.ApproveTransaction;
import com.enigmacamp.loanapp.model.request.LoanTransactionRequest;
import com.enigmacamp.loanapp.model.request.TransactionRequest;
import com.enigmacamp.loanapp.model.response.LoanTransactionResponse;
import com.enigmacamp.loanapp.repository.CustomerRepository;
import com.enigmacamp.loanapp.repository.InstalmentTypeRepository;
import com.enigmacamp.loanapp.repository.LoanTransactionRepository;
import com.enigmacamp.loanapp.repository.LoanTypeRepository;
import com.enigmacamp.loanapp.service.LoanTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanTransactionImpl implements LoanTransactionService {
    private final LoanTransactionRepository loanTransactionRepository;
    private final CustomerRepository customerRepository;
    private final InstalmentTypeRepository instalmentTypeRepository;
    private final LoanTypeRepository loanTypeRepository;

    @Override
    public LoanTransactionResponse saveLoanTransaction(TransactionRequest transactionRequest) {
        LoanTransaction loanTransaction = new LoanTransaction();
        loanTransaction.setNominal(transactionRequest.getNominal());
        loanTransaction.setCreatedAt(new Date().getTime());

        System.out.println(transactionRequest.getCustomer().getId());

        Customer customer = customerRepository.findById(transactionRequest.getCustomer().getId()).get();
        InstalmentType instalmentType = instalmentTypeRepository.findById(transactionRequest.getInstalmentType().getId()).get();
        LoanType loanType = loanTypeRepository.findById(transactionRequest.getLoanType().getId()).get();

        loanTransaction.setCustomer(customer);
        loanTransaction.setLoanType(loanType);
        loanTransaction.setInstalmentType(instalmentType);

        LoanTransaction loanTransaction1 = loanTransactionRepository.save(loanTransaction);
        LoanTransactionResponse loanTransactionResponse = new LoanTransactionResponse();

        loanTransactionResponse.setId(loanTransaction1.getId());
        loanTransactionResponse.setLoanTypeId(loanTransaction1.getInstalmentType().getId());
        loanTransactionResponse.setNominal(loanTransaction1.getNominal());
        loanTransactionResponse.setCreatedAt(loanTransaction1.getCreatedAt());
        loanTransactionResponse.setCustomerId(loanTransaction1.getCustomer().getId());
        loanTransactionResponse.setInstalmentTypeId(loanTransaction1.getInstalmentType().getId());
        return loanTransactionResponse;
    }

    @Override
    public LoanTransaction approveTransactionByAdmin(ApproveTransaction approveTransaction) {
        Optional<LoanTransaction> loanTransaction = loanTransactionRepository.findById(approveTransaction.getLoanTransactionId());
        return null;
    }
}

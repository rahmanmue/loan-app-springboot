package com.enigmacamp.loanapp.controller;

import com.enigmacamp.loanapp.model.entity.LoanTransaction;
import com.enigmacamp.loanapp.model.request.ApproveTransaction;
import com.enigmacamp.loanapp.model.request.LoanTransactionRequest;
import com.enigmacamp.loanapp.model.request.TransactionRequest;
import com.enigmacamp.loanapp.model.response.CommonResponse;
import com.enigmacamp.loanapp.model.response.LoanTransactionResponse;
import com.enigmacamp.loanapp.service.LoanTransactionService;
import com.enigmacamp.loanapp.utils.constant.ApiPathConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPathConstant.API + ApiPathConstant.TRANSACTIONS)
public class LoanTransactionController {

    @Autowired
    LoanTransactionService loanTransactionService;

    @PostMapping
    @PreAuthorize("hasAnyRole({'ROLE_CUSTOMER'})")
    public ResponseEntity<CommonResponse<LoanTransactionResponse>> saveTransaction(@RequestBody TransactionRequest transactionRequest){
        CommonResponse<LoanTransactionResponse> commonResponse = new CommonResponse<>();
        System.out.println(transactionRequest.toString());
        LoanTransactionResponse result = loanTransactionService.saveLoanTransaction(transactionRequest);
        commonResponse.setData(result);
        commonResponse.setMessage("Success Insert Transaction");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commonResponse);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_STAFF'})")
    public LoanTransaction approveTransaction(@RequestBody ApproveTransaction approveTransaction){
        return null;
    }

}

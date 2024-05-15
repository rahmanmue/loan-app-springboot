package com.enigmacamp.loanapp.controller;

import com.enigmacamp.loanapp.model.entity.InstalmentType;
import com.enigmacamp.loanapp.model.entity.LoanType;
import com.enigmacamp.loanapp.model.response.CommonResponse;
import com.enigmacamp.loanapp.service.LoanTypeService;
import com.enigmacamp.loanapp.utils.constant.ApiPathConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiPathConstant.API + ApiPathConstant.LOAN_TYPES)
public class LoanTypeController {
    @Autowired
    LoanTypeService loanTypeService;

    @PostMapping
    public ResponseEntity<CommonResponse<LoanType>> saveLoanType(@RequestBody LoanType loanType){
        LoanType loanType1 = loanTypeService.saveLoanType(loanType);
        CommonResponse<LoanType> commonResponse = new CommonResponse<>();
        commonResponse.setData(loanType1);
        commonResponse.setMessage("Success insert loan type");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commonResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<LoanType>> getLoanTypeById(@PathVariable String id){
        Optional<LoanType> optionalLoanType = loanTypeService.getLoanTypeById(id);
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Success get loan type by id");
        commonResponse.setData(optionalLoanType);
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<LoanType>>> getAllLoanTypes(){
        List<LoanType> loanTypeList = loanTypeService.getAllLoanTypes();
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Success get all instalment type by");
        commonResponse.setData(loanTypeList);
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_STAFF'})")
    public  ResponseEntity<CommonResponse<LoanType>> updateLoanTypeById(@RequestBody LoanType loanType){
        LoanType loanType1 = loanTypeService.updateLoanType(loanType);
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Success update loan type by id");
        commonResponse.setData(loanType1);
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteLoanType(@PathVariable String id){
        CommonResponse commonResponse = new CommonResponse<>();
        loanTypeService.deleteLoanType(id);
        commonResponse.setMessage("Data Deleted");
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);

    }




}

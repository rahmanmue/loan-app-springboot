package com.enigmacamp.loanapp.service.impl;

import com.enigmacamp.loanapp.model.entity.LoanType;
import com.enigmacamp.loanapp.repository.LoanTypeRepository;
import com.enigmacamp.loanapp.service.LoanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanTypeServiceImpl implements LoanTypeService {
    @Autowired
    LoanTypeRepository loanTypeRepository;


    @Override
    public LoanType saveLoanType(LoanType loanType) {
        return loanTypeRepository.save(loanType);
    }

    @Override
    public LoanType updateLoanType(LoanType loanType) {
        if(loanTypeRepository.findById(loanType.getId()).isPresent()){
            return loanTypeRepository.save(loanType);
        }else{
            throw new RuntimeException("Loan type with id "+ loanType.getId()+" Not Found");
        }
    }

    @Override
    public Optional<LoanType> getLoanTypeById(String id) {
        return loanTypeRepository.findById(id);
    }

    @Override
    public List<LoanType> getAllLoanTypes() {
        return loanTypeRepository.findAll();
    }

    @Override
    public void deleteLoanType(String id) {
        loanTypeRepository.deleteById(id);
    }
}

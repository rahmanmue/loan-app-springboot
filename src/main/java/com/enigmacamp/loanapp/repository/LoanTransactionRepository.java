package com.enigmacamp.loanapp.repository;

import com.enigmacamp.loanapp.model.entity.LoanTransaction;
import com.enigmacamp.loanapp.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTransactionRepository extends JpaRepository<LoanTransaction, String> {
}

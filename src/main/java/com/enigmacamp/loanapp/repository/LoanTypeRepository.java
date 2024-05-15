package com.enigmacamp.loanapp.repository;

import com.enigmacamp.loanapp.model.entity.InstalmentType;
import com.enigmacamp.loanapp.model.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, String> {
}

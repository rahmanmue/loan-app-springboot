package com.enigmacamp.loanapp.repository;

import com.enigmacamp.loanapp.model.entity.Customer;
import com.enigmacamp.loanapp.model.entity.InstalmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalmentTypeRepository extends JpaRepository<InstalmentType, String> {

}

package com.enigmacamp.loanapp.repository;

import com.enigmacamp.loanapp.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("Select c from Customer c where c.status = false")
    List<Customer> getAllCustomers();
    Customer findByStatusIsFalseAndIdIs(String id);

}

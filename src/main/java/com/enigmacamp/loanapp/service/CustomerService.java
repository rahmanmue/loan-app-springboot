package com.enigmacamp.loanapp.service;

import com.enigmacamp.loanapp.model.entity.Customer;
import com.enigmacamp.loanapp.model.request.CustomerRequest;
import com.enigmacamp.loanapp.model.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    CustomerResponse getCustomerById(String id);
    List<CustomerResponse> getAllCustomers();
    CustomerRequest updateCustomer(CustomerRequest customerRequest);
    void deleteCustomer(String id);
}

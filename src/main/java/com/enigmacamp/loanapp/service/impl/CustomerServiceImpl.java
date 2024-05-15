package com.enigmacamp.loanapp.service.impl;

import com.enigmacamp.loanapp.model.entity.Customer;
import com.enigmacamp.loanapp.model.request.CustomerRequest;
import com.enigmacamp.loanapp.model.response.CustomerResponse;
import com.enigmacamp.loanapp.repository.CustomerRepository;
import com.enigmacamp.loanapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        Customer customer =  customerRepository.findByStatusIsFalseAndIdIs(id);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setPhone(customerResponse.getPhone());
        customerResponse.setStatus(customer.isStatus());
        customerResponse.setDateOfBirth(customer.getDateOfBirth());
        System.out.println(customerResponse);
        return customerResponse;
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.getAllCustomers();
        List<CustomerResponse> customerResponse = new ArrayList<>();

        for(Customer customer : customers){
            CustomerResponse crdo = new CustomerResponse();
            crdo.setId(customer.getId());
            crdo.setFirstName(customer.getFirstName());
            crdo.setLastName(customer.getLastName());
            crdo.setPhone(customer.getPhone());
            crdo.setDateOfBirth(customer.getDateOfBirth());
            crdo.setStatus(customer.isStatus());

            customerResponse.add(crdo);
        }

        return customerResponse;
    }

    @Override
    public CustomerRequest updateCustomer(CustomerRequest customerRequest) {
        if(customerRepository.findById(customerRequest.getId()).isPresent()){
            Customer customer = new Customer();
            customer.setPhone(customerRequest.getPhone());
            customer.setFirstName(customer.getFirstName());
            customer.setDateOfBirth(customer.getDateOfBirth());
            customer.setLastName(customer.getLastName());
            customerRepository.save(customer);
            return customerRequest;
        }else{
            throw new RuntimeException("Customer with id "+ customerRequest.getId()+" Not Found");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

}

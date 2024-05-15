package com.enigmacamp.loanapp.controller;

import com.enigmacamp.loanapp.model.request.CustomerRequest;
import com.enigmacamp.loanapp.model.response.CommonResponse;
import com.enigmacamp.loanapp.model.response.CustomerResponse;
import com.enigmacamp.loanapp.service.CustomerService;
import com.enigmacamp.loanapp.utils.constant.ApiPathConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPathConstant.API + ApiPathConstant.CUSTOMERS)
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @PutMapping
    public ResponseEntity<CommonResponse<CustomerResponse>> updateCustomer(@RequestBody CustomerRequest customerRequest){
        CommonResponse commonResponse = new CommonResponse<>();
        CustomerRequest customerRequest1 = customerService.updateCustomer(customerRequest);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customerRequest1.getId());
        customerResponse.setFirstName(customerRequest1.getFirstName());
        customerResponse.setLastName(customerRequest1.getLastName());
        customerResponse.setPhone(customerRequest1.getPhone());
        customerResponse.setStatus(customerResponse.isStatus());
        customerResponse.setDateOfBirth(customerRequest1.getDateOfBirth());
        commonResponse.setData(customerResponse);
        commonResponse.setMessage("Successfully update user by id");
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);
    }


    @GetMapping
    public ResponseEntity<CommonResponse<List<CustomerResponse>>> getAllCustomers(){
        List<CustomerResponse> customerResponse = customerService.getAllCustomers();
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setData(customerResponse);
        commonResponse.setMessage("Successfully fetch user");
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<CustomerResponse>> getCustomerById(@PathVariable String id){
        CommonResponse commonResponse = new CommonResponse<>();
        CustomerResponse customerResponse = customerService.getCustomerById(id);
        commonResponse.setData(customerResponse);
        commonResponse.setMessage("Successfully fetch user by id");
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteCustomer(@PathVariable String id){
        CommonResponse commonResponse = new CommonResponse<>();
        customerService.deleteCustomer(id);
        commonResponse.setMessage("Data Deleted");
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);

    }

}

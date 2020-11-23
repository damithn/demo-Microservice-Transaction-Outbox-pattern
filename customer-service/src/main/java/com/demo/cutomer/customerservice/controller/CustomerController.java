package com.demo.cutomer.customerservice.controller;

import com.demo.cutomer.customerservice.dto.CustomerDTO;
import com.demo.cutomer.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/customer/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO) throws Exception {
        return customerService.save(customerDTO);
    }

}

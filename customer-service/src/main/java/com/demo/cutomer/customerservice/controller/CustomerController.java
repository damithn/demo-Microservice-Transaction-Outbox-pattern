package com.demo.cutomer.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cutomer.customerservice.dto.CustomerDTO;
import com.demo.cutomer.customerservice.service.CustomerService;

/**
 * This controller handle All customer related API calls.
 *
 * @author Damith Samarakoon
 */
@RestController
public class CustomerController {

    /**
     * Handle to the service.
     */
    @Autowired
    CustomerService customerService;

    /**
     * save Customer.
     *
     * @param customerDTO
     * @return CustomerDTO
     */
    @PostMapping(value = "/customer/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO) throws Exception {
        return customerService.save(customerDTO);
    }

}

package com.demo.cutomer.customerservice.service;

import com.demo.cutomer.customerservice.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO) throws Exception;
}

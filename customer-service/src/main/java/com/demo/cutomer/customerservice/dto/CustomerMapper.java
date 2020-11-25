package com.demo.cutomer.customerservice.dto;

import org.springframework.stereotype.Component;

import com.demo.cutomer.customerservice.dao.entity.CustomerEntity;

/**
 * This class maps the Entity object fetched from the DataBase and builds a Data Transfer Object (DTO), which will be
 * the response from the REST API.
 *
 * @author Damith Samarakoon
 */

@Component
public class CustomerMapper {
    public CustomerDTO customerEntityToDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customerEntity.getCustomerId());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setEmail(customerEntity.getEmal());
        customerDTO.setAddress(customerEntity.getAddress());

        return customerDTO;
    }

    public CustomerEntity customerDTOToEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerDTO.getCustomerId());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setEmal(customerDTO.getEmail());
        customerEntity.setAddress(customerDTO.getAddress());

        return customerEntity;
    }
}

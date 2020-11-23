package com.demo.cutomer.customerservice.dto;


import com.demo.cutomer.customerservice.dao.entity.CustomerEntity;
import org.springframework.stereotype.Component;

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

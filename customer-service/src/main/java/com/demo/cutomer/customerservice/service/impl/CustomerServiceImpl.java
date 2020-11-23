package com.demo.cutomer.customerservice.service.impl;

import com.demo.cutomer.customerservice.dao.entity.CustomerEntity;
import com.demo.cutomer.customerservice.dto.CustomerDTO;
import com.demo.cutomer.customerservice.dto.CustomerMapper;
import com.demo.cutomer.customerservice.outbox.EventPublisher;
import com.demo.cutomer.customerservice.repository.CustomerRepository;
import com.demo.cutomer.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EventPublisher eventPublisher;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) throws Exception {

        CustomerEntity customerEntity = customerMapper.customerDTOToEntity(customerDTO);
        customerRepository.save(customerEntity);

        //publish the event
        eventPublisher.fire(EventUtils.saveCustomerEvent(customerEntity));
        return customerMapper.customerEntityToDTO(customerEntity);
    }
}

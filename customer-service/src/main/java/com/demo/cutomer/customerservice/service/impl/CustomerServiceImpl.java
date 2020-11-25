package com.demo.cutomer.customerservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.cutomer.customerservice.dao.entity.CustomerEntity;
import com.demo.cutomer.customerservice.dto.CustomerDTO;
import com.demo.cutomer.customerservice.dto.CustomerMapper;
import com.demo.cutomer.customerservice.outbox.EventPublisher;
import com.demo.cutomer.customerservice.repository.CustomerRepository;
import com.demo.cutomer.customerservice.service.CustomerService;

/**
 * Service Implementation that fetches / acts on {@link CustomerDTO} related data.
 *
 * @author Damith Samarakoon
 */

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    /**
     * Handle to the Data Access Layer.
     */
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EventPublisher eventPublisher;

    @Autowired
    CustomerMapper customerMapper;

    /**
     * Save Customer details
     *
     * @param customerDTO
     * @return CustomerDTO
     */
    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) throws Exception {
        log.info("Create Customer: {}", customerDTO.getName());

        CustomerEntity customerEntity = customerMapper.customerDTOToEntity(customerDTO);
        customerRepository.save(customerEntity);

        //publish the event
        //same transaction seems like async
        eventPublisher.fire(EventUtils.saveCustomerEvent(customerEntity));
        return customerMapper.customerEntityToDTO(customerEntity);
    }
}

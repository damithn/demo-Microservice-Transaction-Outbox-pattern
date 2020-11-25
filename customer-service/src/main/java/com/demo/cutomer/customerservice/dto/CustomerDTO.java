package com.demo.cutomer.customerservice.dto;

import lombok.Data;

/**
 * POJO for holding Customer related data
 */
@Data
public class CustomerDTO {
    private Integer customerId;

    private String name;

    private String email;

    private String address;
}

package com.demo.cutomer.customerservice.dao.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

/**
 * Entity that maps the CUSTOMER table.
 */

@Data
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "ID")
    private Integer customerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String emal;

    @Column(name = "ADDRESS")
    private String address;
}

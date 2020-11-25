package com.demo.cutomer.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cutomer.customerservice.dao.entity.CustomerEntity;

/**
 * This interface provides handles to database, to perform CRUD operations on the table `CUSTOMER`.
 * The table is represented by the JPA entity {@link CustomerEntity}.
 *
 * @author Damith Samarakoon
 * @see JpaRepository
 */

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

}

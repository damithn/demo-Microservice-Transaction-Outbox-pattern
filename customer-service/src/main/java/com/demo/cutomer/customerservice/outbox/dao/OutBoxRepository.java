package com.demo.cutomer.customerservice.outbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cutomer.customerservice.outbox.model.OutboxEntity;

/**
 * This interface provides handles to database, to perform CRUD operations on the table `OUTBOX`.
 * The table is represented by the JPA entity {@link OutboxEntity}.
 *
 * @author Damith Samarakoon
 * @see JpaRepository
 */
@Repository
public interface OutBoxRepository extends JpaRepository<OutboxEntity,Integer> {
}

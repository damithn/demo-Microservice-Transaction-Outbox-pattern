package com.demo.cutomer.customerservice.outbox.dao;

import com.demo.cutomer.customerservice.outbox.model.OutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutBoxRepository extends JpaRepository<OutboxEntity,Integer> {
}

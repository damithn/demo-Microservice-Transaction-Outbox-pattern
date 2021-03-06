package com.demo.cutomer.customerservice.outbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity that maps the Eventing OUTBOX table.
 *
 * @author Damith Samarakoon
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OUTBOX")
public class OutboxEntity {
    @Id
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "aggregateId")
    private Integer aggregateId;

    @Column(name = "eventType")
    private String eventType;

    @Column(name = "payload")
    private String payload;

    @Column(name = "createdOn")
    private Date createdOn;
}

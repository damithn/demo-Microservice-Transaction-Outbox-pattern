package com.demo.cutomer.customerservice.service.impl;

import com.demo.cutomer.customerservice.dao.entity.CustomerEntity;
import com.demo.cutomer.customerservice.outbox.model.OutboxEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class to help the service in building event payloads.
 *
 * @author Damith Samarakoon
 */
public class EventUtils {
    /**
     * Create the event object to be published when new Customer is Created.
     *
     * @param customerEntity
     * @return OutboxEvent
     */
    public static OutboxEvent saveCustomerEvent(CustomerEntity customerEntity) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.convertValue(customerEntity, JsonNode.class);

        return new OutboxEvent(
                customerEntity.getCustomerId(),
                "CUSTOMER_SAVED",
                jsonNode
        );
    }
}

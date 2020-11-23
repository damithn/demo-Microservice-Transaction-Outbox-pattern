package com.demo.cutomer.customerservice.service.impl;

import com.demo.cutomer.customerservice.dao.entity.CustomerEntity;
import com.demo.cutomer.customerservice.outbox.model.OutboxEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventUtils {
    public static OutboxEvent saveCustomerEvent(CustomerEntity customerEntity) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.convertValue(customerEntity, JsonNode.class);

        return new OutboxEvent(
                customerEntity.getCustomerId(),
                "CUSTOMER SAVED",
                jsonNode
        );
    }
}

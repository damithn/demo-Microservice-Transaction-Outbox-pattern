package com.demo.cutomer.customerservice.outbox;

import com.demo.cutomer.customerservice.outbox.dao.OutBoxRepository;
import com.demo.cutomer.customerservice.outbox.model.OutboxEntity;
import com.demo.cutomer.customerservice.outbox.model.OutboxEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    OutBoxRepository outBoxRepository;

    @Autowired
    public EventService(OutBoxRepository outBoxRepository) {
        this.outBoxRepository = outBoxRepository;
    }

    @EventListener
    public void handleOutboxEvent(OutboxEvent outboxEvent) {

        UUID uuid = UUID.randomUUID();
        OutboxEntity outboxEntity = new OutboxEntity(
                uuid,
                outboxEvent.getAggregateId(),
                outboxEvent.getEventType(),
                outboxEvent.getPayload().toString(),
                new Date()
        );
        outBoxRepository.save(outboxEntity);
        /*
         * Delete the event once written, so that the outbox doesn't grow.
         * The CDC eventing polls the database log entry and not the table in the database.
         */
        outBoxRepository.delete(outboxEntity);

    }
}

package com.demo.cutomer.customerservice.outbox;

import java.util.Date;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.demo.cutomer.customerservice.outbox.dao.OutBoxRepository;
import com.demo.cutomer.customerservice.outbox.model.OutboxEntity;
import com.demo.cutomer.customerservice.outbox.model.OutboxEvent;

/**
 * Event Service responsible for persisting the event in the database.
 *
 * @author Damith Samarakoon
 */

@Service
@Slf4j
public class EventService {

    /**
     * Handle to the Data Access Layer.
     */
    @Autowired
    OutBoxRepository outBoxRepository;

    @Autowired
    public EventService(OutBoxRepository outBoxRepository) {
        this.outBoxRepository = outBoxRepository;
    }

    /**
     * This method handles all the events fired by the 'EventPublisher'. The method listens to events
     * and persists them in the database.
     *
     * @param outboxEvent
     */
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
        log.info("Handling event : {}.", outboxEntity);
        outBoxRepository.save(outboxEntity);
        /*
         * Delete the event once written, so that the outbox doesn't grow.
         * The CDC eventing polls the database log entry and not the table in the database.
         */
       // outBoxRepository.delete(outboxEntity);

    }
}

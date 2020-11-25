package com.demo.cutomer.customerservice.outbox;

import com.demo.cutomer.customerservice.outbox.model.OutboxEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher implements ApplicationEventPublisherAware {

    /**
     * Instance of the publisher.
     */
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    /**
     * This method publishes the event on to listeners configured by "@EventListener".
     *
     * @param outboxEvent
     */
    public void fire(OutboxEvent outboxEvent) {
        this.publisher.publishEvent(outboxEvent);
    }
}

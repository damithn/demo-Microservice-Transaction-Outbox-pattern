package com.demo.messageservice.listener;

import com.demo.messageservice.dto.CustomerStatusDto;
import com.demo.messageservice.service.EmailService;
import com.demo.messageservice.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerChangeMailListener {
    @Autowired
    EmailService emailService;

    @Autowired
    TemplateService templateService;

    @KafkaListener(topicPattern = "${kafka.topics.customer-status-changed}",autoStartup = "")
    public void listenToCustomerChange(ConsumerRecord<String, CustomerStatusDto> record){
        log.info("Request for customer status change received: " + record.toString());

        CustomerStatusDto customerStatusDto = record.value();

        if (customerStatusDto.getAuthorEmailAddress() == null) {
            log.warn("Ignoring request to send an e-mail without e-mail address: " + record.toString());
            return;
        }

        try {
            emailService.sendEmail(
                    customerStatusDto.getAuthorEmailAddress(),
                    "Hi",
                    templateService.generateProjectStatusChangeEmail(customerStatusDto)
            );
        } catch (MailException e) {
            log.error("Could not send e-mail", e);
        }
    }
}

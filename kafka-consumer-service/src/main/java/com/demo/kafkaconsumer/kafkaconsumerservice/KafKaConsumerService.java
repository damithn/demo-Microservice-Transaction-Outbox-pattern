package com.demo.kafkaconsumer.kafkaconsumerservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;


@Service
public class KafKaConsumerService {
    private final Logger logger =
            LoggerFactory.getLogger(KafKaConsumerService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void consume(String message) {
        logger.info(String.format("Message recieved -> %s", message));

        System.out.println("Sending Email...");

        try {

            sendEmail();

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("damithsliit@gmail.com", "2@yahoo.com");

        msg.setSubject("Congratulations Notification");
        msg.setText("hello !! Congratulations !! You Added to the System.");

        javaMailSender.send(msg);

    }
}

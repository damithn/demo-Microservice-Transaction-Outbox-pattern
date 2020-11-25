package com.demo.messageservice.controller;

import com.demo.messageservice.config.KafkaProperties;
import com.demo.messageservice.dto.CustomerStatusDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
@Slf4j
public class MessageController {
    private KafkaTemplate<String, CustomerStatusDto> kafkaProducer;
    private KafkaProperties kafkaProperties;

    public void sendEmail(@RequestBody CustomerStatusDto customerStatusDto){
        log.info("sending mailing request: "+customerStatusDto.toString());
        kafkaProducer.send(kafkaProperties.getTopics().getProjectStatusChanged(),customerStatusDto);
    }
    
}

package com.demo.messageservice.service;

import com.demo.messageservice.dto.CustomerStatusDto;
import com.demo.messageservice.dto.EmailContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
@RequiredArgsConstructor
public class TemplateService {
    
    private final SpringTemplateEngine templateEngine;

    public EmailContentDto generateProjectStatusChangeEmail(CustomerStatusDto customerStatusDto) {
        Context context = new Context();
        context.setVariable("fullName", customerStatusDto.getAuthorFullName());

        return EmailContentDto
                .builder()
                .text(templateEngine.process("customer-status.txt", context))
                .build();
    }
}


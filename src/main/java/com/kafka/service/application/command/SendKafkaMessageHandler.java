package com.kafka.service.application.command;

import com.kafka.service.domain.service.KafkaDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendKafkaMessageHandler {

    private final KafkaDomainService kafkaDomainService;

    @Autowired
    public SendKafkaMessageHandler(KafkaDomainService kafkaDomainService) {
        this.kafkaDomainService = kafkaDomainService;
    }

    public void handle(SendKafkaMessageCommand command) {
        kafkaDomainService.send(command.getMessage());
    }
}


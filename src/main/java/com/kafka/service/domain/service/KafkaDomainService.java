package com.kafka.service.domain.service;

import com.kafka.service.application.command.SendKafkaMessageCommand;
import com.kafka.service.infrastructure.adapter.messaging.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaDomainService {

    private final String topic = "pdf";
    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaDomainService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void send(String message) {
        kafkaProducer.sendMessage(topic, message);
    }
}


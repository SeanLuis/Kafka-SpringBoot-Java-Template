package com.kafka.service.infrastructure.adapter.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.service.application.command.SendKafkaMessageCommand;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, SendKafkaMessageCommand> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, SendKafkaMessageCommand> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, new SendKafkaMessageCommand(message));
    }
}


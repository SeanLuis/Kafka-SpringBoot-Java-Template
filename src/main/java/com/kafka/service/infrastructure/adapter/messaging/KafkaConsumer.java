package com.kafka.service.infrastructure.adapter.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "pdf", groupId = "example")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}

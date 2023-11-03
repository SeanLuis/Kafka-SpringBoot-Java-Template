package com.kafka.service.infrastructure.adapter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.service.application.command.SendKafkaMessageCommand;
import com.kafka.service.application.command.SendKafkaMessageHandler;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final SendKafkaMessageHandler sendKafkaMessageHandler;

    @Autowired
    public MessageController(SendKafkaMessageHandler sendKafkaMessageHandler) {
        this.sendKafkaMessageHandler = sendKafkaMessageHandler;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody SendKafkaMessageCommand command) {
        sendKafkaMessageHandler.handle(command);
        return ResponseEntity.ok("Mensaje enviado a Kafka con éxito");
    }
}
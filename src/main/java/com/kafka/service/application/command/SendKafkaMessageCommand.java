package com.kafka.service.application.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SendKafkaMessageCommand {
    private String message;

    @JsonCreator
    public SendKafkaMessageCommand(@JsonProperty("message") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SendKafkaMessageCommand{" +
                "message='" + message + '\'' +
                '}';
    }
}

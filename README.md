
# Spring Boot Kafka Service Documentation

## Overview

This document outlines the setup and configuration for a Spring Boot application that utilizes Apache Kafka for messaging. The application is built with Maven and Java 17, and it also integrates a MySQL database. Apache Kafka, Zookeeper, and Kafdrop are containerized using Docker Compose.

## Project Structure

The project is structured following standard Maven conventions:

- `src/main/java/com/kafka/service`: Contains the main application codebase.
  - `application`: Contains command handlers and DTOs.
  - `domain`: Contains the domain services.
  - `infrastructure`: Contains adapters for web, messaging (Kafka), and configuration classes.
- `src/main/resources`: Contains configuration files and resources.
- `src/test/java`: Contains unit and integration tests.

## Configuration Files

- `application.properties` or `application.yml`: Defines Spring Boot specific configurations including server port, database settings, and Kafka properties.
- `docker-compose.yml`: Defines the services for Kafka, Zookeeper, and Kafdrop, along with their respective configurations.

## Kafka Configuration

The Kafka configuration is managed within the `KafkaConfiguration` class:

- `producerFactory`: Defines the configuration properties for Kafka producers.
- `kafkaTemplate`: Provides a template for sending messages to Kafka topics.
- `consumerFactory`: Defines the configuration properties for Kafka consumers.
- `kafkaListenerContainerFactory`: Sets up the listener container for Kafka messages.

### Default Kafka Settings

- Group ID: `example`
- Topic: `pdf`
- Kafka Broker: `localhost:29092`

### Changing Configuration Parameters

To modify Kafka settings, update the `producerFactory` and `consumerFactory` methods in the `KafkaConfiguration` class with the desired properties.

## Docker Compose for Kafka

The `docker-compose.yml` file sets up the Kafka environment:

- `zookeeper`: Manages Kafka's state.
- `kafka`: The Kafka broker itself.
- `kafdrop`: A web UI for viewing Kafka topics and browsing consumer groups.

### Volumes

- `kafka_data`: Stores Kafka's data persistently.

### Ports

- Zookeeper: `2181`
- Kafka: `9092` for internal and `29092` for external connections.
- Kafdrop: `9010`

## Running the Project

- The Spring Boot application runs on port `8090`.
- Kafka and its components are started with Docker Compose using the `docker-compose.yml` file.

## Sending Messages

To send messages to Kafka, use the `sendMessage` endpoint defined in the `MessageController`:

- HTTP POST to `/api/messages/send`
- Request body should contain the `SendKafkaMessageCommand` JSON structure.

## Consuming Messages

Kafka messages are consumed by the `KafkaListener` methods within the application, which process incoming messages from the configured topics.

## Additional Notes

- The project is not fully containerized; only the Kafka setup is managed with Docker Compose.
- To view Kafka topics and message flows, access Kafdrop at `http://localhost:9010`.

## Conclusion

This documentation provides a basic outline for the Spring Boot Kafka Service project. For detailed configuration and usage, refer to the source code and configuration files.

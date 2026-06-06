# Payment Service

## Overview

Payment Service is a Spring Boot-based microservice responsible for handling payment and refund operations in an event-driven architecture.

The service consumes events from multiple sources through Apache Kafka and performs the required business actions such as payment processing, refund initiation, payment status updates, and transaction tracking.

It is designed to be scalable, fault-tolerant, and capable of processing high-volume financial transactions in distributed microservice environments.

---

## Features

- Process customer payments
- Handle payment refunds
- Event-driven payment processing
- Consume events from multiple services
- Publish payment status events
- Transaction tracking and auditing
- Retry and failure handling
- Kafka-based asynchronous communication
- REST APIs for payment operations
- Database persistence and transaction management
- Scalable microservice architecture

---

## Architecture

```text
+------------------+
|   API Gateway    |
+--------+---------+
         |
         v
+------------------+
| Payment Service  |
+--------+---------+
         |
    +----+----+
    |         |
    v         v
 Kafka      MySQL
 Events    Database
```

---

## Event Flow

### Payment Processing

```text
Order Created Event
        |
        v
Payment Service
        |
        v
Process Payment
        |
        v
Payment Completed Event
```

### Refund Processing

```text
Refund Requested Event
        |
        v
Payment Service
        |
        v
Process Refund
        |
        v
Refund Completed Event
```

---

## Technology Stack

| Technology | Purpose |
|------------|----------|
| Java | Core Development |
| Spring Boot | Application Framework |
| Spring Web | REST APIs |
| Spring Data JPA | Database Access |
| Apache Kafka | Event Streaming |
| MySQL | Data Persistence |
| API Gateway | Request Routing |
| Maven | Dependency Management |
| Docker | Containerization |
| GitHub | Source Control |
| JUnit | Unit Testing |

---

## Key Responsibilities

- Consume payment-related events
- Process customer payments
- Process refunds
- Maintain payment records
- Publish payment status events
- Ensure reliable message processing
- Support asynchronous communication
- Handle transaction failures and retries
- Maintain audit history

---

## Kafka Topics

### Consumed Topics

- `order-created`
- `payment-requested`
- `refund-requested`

### Produced Topics

- `payment-completed`
- `payment-failed`
- `refund-completed`
- `refund-failed`

---

## Database

The service uses MySQL for storing:

- Payment Transactions
- Refund Transactions
- Payment Status
- Transaction History
- Audit Information

---

## Reliability Features

- Kafka Consumer Groups
- Retry Mechanism
- Idempotent Processing
- Dead Letter Queue (DLQ)
- Transaction Management
- Error Handling
- Event-Driven Architecture

---

## Future Enhancements

- Distributed Tracing
- Circuit Breaker Integration
- Payment Gateway Integrations
- Real-Time Monitoring
- Advanced Fraud Detection
- Multi-Currency Support

---

## Author

Developed as part of a Microservices and Event-Driven Architecture ecosystem using Spring Boot and Apache Kafka By Abhinandan Kumar Shah (AKS).

# Microservices Banking Application
Welcome to the Microservices Banking Application, a modern and scalable banking solution built with microservices architecture. This project consists of three main microservices, each serving a specific function in the banking ecosystem:

## Accounts Service

## Overview
The "accounts" microservice is responsible for managing customer accounts and related transactions within the Bank Microservices Application.
Leveraging Spring Boot and Spring Cloud technologies, this microservice ensures robustness, scalability, and seamless integration with the broader banking ecosystem.

## Features
RESTful CRUD Operations: Implements comprehensive REST APIs for creating, updating, fetching, and deleting customer accounts. Ensures seamless communication with other microservices.
Validation and Error Handling: Incorporates Spring Boot's validation mechanisms and provides detailed error responses for enhanced reliability.
External Configuration: Utilizes Spring Cloud Config Client to dynamically manage configurations, ensuring flexibility and easy maintenance.
Service Discovery: Integrates seamlessly with Kubernetes Discovery Client for efficient service registration and discovery in a dynamic environment.
Resilience and Fault Tolerance: Employs Resilience4j for rate limiting and retry mechanisms, enhancing system resilience in the face of failures.
Communication with Other Microservices: Utilizes Spring Cloud OpenFeign for streamlined communication with other microservices, fostering a cohesive banking ecosystem.
Containerized Deployment: Dockerizes the application and utilizes Jib Maven Plugin for simplified container image creation and deployment.
Database Management: Utilizes H2 database for efficient storage and retrieval of account-related data.
API Documentation: Implements OpenAPI with Springdoc for clear and accessible API documentation.
Build and Deployment
The microservice is built using Maven and features a convenient Jib Maven Plugin for containerization. The Docker images are hosted on Docker Hub for easy accessibility. 
The application seamlessly integrates with Kubernetes and Helm for efficient orchestration and deployment.

## Monitoring and Logging
Monitoring and logging are critical components of this microservice. The integration of Grafana, Loki, and Tempo ensures real-time insights into the microservice's performance, logs, and traces.

Authentication and Security
The "accounts" microservice incorporates Keycloak as the authentication server, ensuring secure access and interactions within the banking ecosystem.

Continuous Improvement
The microservice features resilience mechanisms such as rate limiting and retry, ensuring robustness even in challenging conditions. Continuous improvement is emphasized through version retrieval and fallback mechanisms for build and Java versions.
Manages customer accounts and related transactions.
Utilizes H2 database for data storage.
Cards Service

Handles credit/debit card functionalities.
Interacts with external systems for card-related operations.
Loans Service

Manages loan applications and approvals.
Utilizes H2 database for data storage.
Key Features
Spring Cloud Microservices: Built using Spring Boot and Spring Cloud for creating scalable and resilient microservices.
External Configuration: Utilizes a Git-backed Config Server for managing external configurations.
Service Discovery: Integrates with Eureka Gateway for service registration and discovery.
API Documentation: Implements OpenAPI to ensure clear and accessible API documentation.
Dockerized: All services are containerized and stored on Docker Hub for easy deployment.
Orchestration with Kubernetes and Helm: Leverages Kubernetes for container orchestration and Helm for managing Kubernetes applications.
Authentication with Keycloak: Implements Keycloak as an authentication server to secure the microservices.
Monitoring and Logging: Integrated Grafana, Loki, and Tempo for efficient monitoring and logging solutions.
Load Balancing: Utilizes load balancing to distribute incoming network traffic across multiple services to ensure optimal performance.
Getting Started
Follow the documentation in each microservice's directory to set up and run the application locally or deploy it on a Kubernetes cluster.

Contributing
If you're interested in contributing to the development of the Microservices Banking Application, please check out our contributing guidelines.

We appreciate your support and look forward to building a robust banking solution together!

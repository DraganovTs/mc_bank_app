
# Microservices Banking Application

MC Bank Application is a microservices-based banking application that provides CRUD (Create, Read, Update, Delete) REST APIs for managing customer accounts. The application is designed with a modular architecture using Spring Boot and Maven. It consists of the following modules:





### **Accounts**
- **RESTful CRUD Operations:**
Implements comprehensive REST APIs for creating, updating, fetching, and deleting customer accounts. Ensures seamless communication with other microservices.

- **Validation and Error Handling:** Incorporates Spring Boot's validation mechanisms and provides detailed error responses for enhanced reliability.

- **External Configuration:**
 Utilizes Spring Cloud Config Client to dynamically manage configurations, ensuring flexibility and easy maintenance.

- **Service Discovery:**
 Integrates seamlessly with Kubernetes Discovery Client for efficient service registration and discovery in a dynamic environment.

- **Resilience and Fault Tolerance:** Employs Resilience4j for rate limiting and retry mechanisms, enhancing system resilience in the face of failures.

- **Communication with Other Microservices:** Utilizes Spring Cloud OpenFeign for streamlined communication with other microservices, fostering a cohesive banking ecosystem.

- **Containerized Deployment:** Dockerizes the application and utilizes Jib Maven Plugin for 
simplified container image creation and deployment.

- **Database Management:** Utilizes H2 database for efficient storage and retrieval of account-related data.

- **API Documentation:** Implements OpenAPI with Springdoc for clear and accessible API documentation.

### **Cards**
- **RESTful CRUD Operations:**
Implements robust REST APIs for Creating, Updating, Fetching, and Deleting card details.
Facilitates seamless communication with other microservices within the application.

- **Validation and Error Handling:** Leverages Spring Boot's validation mechanisms to ensure data integrity.
Provides detailed error responses, enhancing the reliability of interactions.

- **External Configuration:**
 Utilizes Spring Cloud Config Client for dynamic management of configurations.
Enhances flexibility and simplifies maintenance through centralized configuration.

- **Service Discovery:**
Integrates seamlessly with Kubernetes Discovery Client for efficient service registration and discovery.
Ensures optimal functioning in dynamic and containerized environments.

- **Resilience and Fault Tolerance:** Employs Resilience4j for effective rate limiting and retry mechanisms.
Enhances system resilience in the face of potential failures.

- **Communication with Other Microservices:** Utilizes Spring Cloud OpenFeign for streamlined communication with other microservices.
Promotes a cohesive banking ecosystem by facilitating efficient data exchange.

- **Containerized Deployment:** Dockerizes the application and utilizes Jib Maven Plugin for 
simplified container image creation and deployment.

- **Database Management:** Utilizes H2 database for efficient storage and retrieval of card-related data.
Ensures a reliable and scalable foundation for managing card details.

- **API Documentation:** Implements OpenAPI with Springdoc for clear and accessible API documentation.
Enhances developer experience and facilitates smooth integration with the microservice.
### **Loans**
- **RESTful CRUD Operations:**
Implements comprehensive REST APIs for Creating, Updating, Fetching, and Deleting loan details.
Ensures smooth communication with other microservices within the application.

- **Validation and Error Handling:** Incorporates Spring Boot's validation mechanisms to maintain data integrity.
Provides detailed error responses for enhanced reliability.

- **External Configuration:**
Utilizes Spring Cloud Config Client for dynamic configuration management.
Enhances flexibility and simplifies maintenance through centralized configuration.

- **Service Discovery:**
Seamlessly integrates with Kubernetes Discovery Client for efficient service registration and discovery.
Ensures optimal functionality in dynamic and containerized environments.

- **Resilience and Fault Tolerance:** Employs Resilience4j for effective rate limiting and retry mechanisms.
Enhances system resilience in the face of potential failures.

- **Communication with Other Microservices:** Utilizes Spring Cloud OpenFeign for streamlined communication with other microservices.
Promotes a cohesive banking ecosystem by facilitating efficient data exchange.

- **Containerized Deployment:** Dockerizes the application for simplified container image creation and deployment.
Utilizes Jib Maven Plugin for optimized container image generation.

- **Database Management:** Utilizes H2 database for efficient storage and retrieval of loan-related data.
Ensures a reliable and scalable foundation for managing loan details.

- **API Documentation:** Implements OpenAPI with Springdoc for clear and accessible API documentation.
Enhances developer experience and facilitates smooth integration with the microservice.
### **Message**
- **Message Processing Functions:**
Provides two primary functions - "email" and "sms" - for processing accounts-related messages.
Utilizes Spring Cloud Stream for simplified event-driven communication.

- **Email Functionality:** Implements a function to send email messages based on the provided account details.
Logs the details of the email message before processing.

- **SMS Functionality:**
Implements a function to send SMS messages based on the provided account details.
Logs the details of the SMS message before processing.

- **Logging and Information:**
Employs SLF4J logging to capture relevant information about the processing functions.
Logs details such as the type of message being sent and the associated account information.

- **Asynchronous Communication:** Leverages Spring Cloud Stream and Kafka binder for asynchronous and decoupled communication.
Enhances system responsiveness and scalability.

- **Containerized Deployment:** Utilizes the Jib Maven Plugin for container image creation, ensuring efficient deployment.

### **Configserver**
- **Spring Cloud Config Server:**
Utilizes the Spring Cloud Config Server to manage and distribute configuration properties.
Acts as a centralized configuration source for other microservices.

- **Git-based Configuration:** Fetches configuration details from a Git repository hosted at "https://github.com/DraganovTs/bankcorp-config.git."
Specifies the Git URI, default label (branch), timeout, and other configuration properties.

- **Actuator Endpoints:**
Enables Spring Boot Actuator endpoints for monitoring and management purposes.
Exposes endpoints such as health, readiness-state, liveness-state, metrics, and other relevant information.

- **OpenTelemetry Integration:**
Integrates with OpenTelemetry for enhanced observability and tracing.
Deploys the OpenTelemetry Java agent at runtime.

- **Containerized Deployment:** Utilizes the Jib Maven Plugin for container image creation, ensuring efficient deployment.

- **Security:** Configures encryption with a specified encryption key for sensitive information.

- **Logging Configuration:** Configures logging patterns to include essential details such as log level, application name, trace ID, and span ID.

- **Management of Git Repository:** Specifies settings such as clone-on-start and force-pull for efficient management of the Git repository.

- **Port Configuration:** Sets the server port to 8071 for external communication.

### **Eurekaserver**
- **Spring Cloud Eureka Server:**
Utilizes the Spring Cloud Netflix Eureka Server for service registration and discovery.

- **Kubernetes Integration:** In a Kubernetes environment, changed with the Kubernetes Discovery Server for efficient service registration and discovery.

- **Actuator Endpoints:**
Enables Spring Boot Actuator endpoints for monitoring and management purposes.
Exposes endpoints such as health, readiness-state, liveness-state, metrics, and other relevant information.

- **OpenTelemetry Integration:**
Integrates with OpenTelemetry for enhanced observability and tracing.
Deploys the OpenTelemetry Java agent at runtime.

- **Containerized Deployment:** Utilizes the Jib Maven Plugin for container image creation, ensuring efficient deployment.

- **Configuration Import:** Optionally imports configuration from the Config Server (http://localhost:8071).

- **Logging Configuration:** Configures logging patterns to include essential details such as log level, application name, trace ID, and span ID.

### **Gatewayserver**
- **Spring Cloud Gateway:**
Utilizes the Spring Cloud Gateway framework for managing and routing requests to the appropriate microservices.

- **Centralized Configuration:** Connects to the Spring Cloud Config Server (http://localhost:8071) for centralized configuration management.

- **Service Discovery:**
Integrates with Kubernetes Discovery Server or Eureka in Docker for dynamic service registration and discovery.

- **OAuth 2.0 Security:**
Implements OAuth 2.0 security for securing endpoints and validating JWT tokens.
Configures role-based access control for specific paths.

- **Resilience4J Circuit Breaker:** Utilizes Resilience4J Circuit Breaker for resilience against failures in remote services.
Default circuit breaker configuration includes sliding window size, permitted calls in half-open state, failure rate threshold, and wait duration in open state.

- **Rate Limiting:** Implements rate limiting using RedisRateLimiter for specific routes to prevent abuse and ensure fair usage.

- **Fallback Mechanism:** Implements a fallback mechanism for the "/contactSupport" route, providing a default message when errors occur.

- **Metrics and Monitoring:** Exposes actuator endpoints for monitoring and management.
Utilizes Micrometer with Prometheus registry for collecting and exporting metrics.

- **Logging Configuration:** Configures detailed logging patterns to include log level, application name, trace ID, and span ID.

- **Containerized Deployment:** Utilizes the Jib Maven Plugin for container image creation, ensuring efficient deployment.

- **Resilience4J Configuration:** Customizes the Resilience4J Circuit Breaker configuration, including sliding window size, permitted calls, failure rate threshold, and wait duration.


## Tech Stack

## Programming Language
- **Java 17:** The primary programming language for development.

## Frameworks and Libraries
- **Spring Boot 3.2.1:** Framework for creating stand-alone, production-grade Spring-based applications.
- **Spring Cloud 2023.0.0:** Tools for building and managing microservices.
- **Spring Cloud Config Server 4.1.0:** Centralized configuration management server.
- **Spring Cloud Eureka Server 4.1.0:** Service discovery and registration server.
- **Spring Cloud Gateway 4.1.1:** Framework for building API gateways.
- **Spring Cloud Netflix Eureka Client 4.1.0:** Eureka client for service registration and discovery.
- **Spring Cloud OpenFeign 4.1.0:** Declarative web service client.
- **Spring Cloud Kubernetes Discovery Client 2.1.3:** Integrates Spring Cloud applications with Kubernetes.
- **Spring Cloud Stream 4.1.0:** Framework for building highly scalable event-driven microservices.
- **Spring Cloud Function Context 4.1.0:** Support for serverless functions.
- **Spring Cloud Function Web 4.1.0:** HTTP adapter for serverless functions.
- **Spring Cloud Stream Binder Rabbit 4.1.0:** Binder implementation for RabbitMQ.
- **Spring Cloud Starter OpenFeign 4.1.0:** Starter for building Feign clients.
- **Spring Cloud Starter Data Redis Reactive 3.2.2:** Starter for reactive Redis support.
- **Micrometer Registry Prometheus 1.12.2:** Micrometer registry for Prometheus monitoring.
- **OpenTelemetry Java Agent 1.32.0:** Provides observability for applications via telemetry data collection.
- **Spring Boot DevTools 3.2.1:** Provides fast application restarts and efficient development tools.
- **Project Lombok 1.18.30:** Library to reduce boilerplate code in Java.
- **H2 Database 2.2.224:** Lightweight in-memory database for development and testing.
- **Spring Boot Starter Validation 3.2.1:** Starter for enabling Bean Validation.
- **Spring Boot Starter Web 3.2.1:** Starter for building web applications.
- **Spring Security OAuth 2.0 Resource Server 6.2.0:** Ensures secure access to resources using OAuth 2.0.
- **Spring Security OAuth 2.0 JOSE 6.2.0:** Support for handling JOSE (JSON Object Signing and Encryption) in OAuth 2.0.
- **Springdoc OpenAPI Starter WebMVC UI 2.3.0:** Auto-generates API documentation using OpenAPI and Swagger UI.
- **Reactive Resilience4J Circuit Breaker:** Resilience4J Circuit Breaker for resilience against failures.
- **Redis Rate Limiter:** Rate limiting using Redis as a backend.

## Containerization
- **Jib Maven Plugin 3.4.0:** Plugin for building container images.

# How to Run

Clone the repository

```bash
  git clone https://github.com/DraganovTs/mc_bank_app.git
```

Go to the project directory

```bash
  cd docker-compose/prod
```

Install dependencies

```bash
  docker-compose up -d
```

At this point everything should be up and running!

## Setting up Keycloak Client with Client Credential Grant Type and Assigned Roles

## 1. Login to Keycloak:
   - http://localhost:7080
   - Open your Keycloak admin console in a web browser.
   - Log in with your administrator credentials.
   - username: admin
   - password: admin

## 2. Use MASTER Realm:
   - Use default Keycloak realm.
   

## 3. Create a Client:
   - Inside your realm, go to the "Clients" section in the left menu.
   - Click "Create" to add a new client.
   - Fill in the necessary information for your client (e.g., `bankcorp-microservices`).
   - Set the Access Type to confidential.
   - Save the client.

## 4. Configure Client Credentials Grant Type:
   - In the "Settings" tab of your client, set Direct Access Grants Enabled to ON.
   - Under the "Service Account Roles" tab, assign the roles `ACCOUNT`, `CARDS`, and `LOANS` as needed.

## 5. Get Client Credentials:
   - Go to the "Credentials" tab for your client.
   - Note the Secret. This is the client secret that will be used to obtain tokens.

---

Now, your Keycloak client is set up to use the client credential grant type and has been assigned the specified roles. When your microservices use this client to obtain tokens, they can use these tokens to access resources based on the assigned roles.



# API Reference

### Customer Controller APIs

```http
    GET http://localhost:8072/bankcorp/accounts/api/fetchCustomerDetails?mobileNumber={mobileNumber}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `mobileNumber` | `string` | **Query**. Customer's mobile number (10 digits). |

### Customer Controller APIs

### Create Account

```http
    POST http://localhost:8072/bankcorp/accounts/api/create
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `customerDTO`      | `object` | **Body**. Customer details for creation. |

### Request Body Example:
{
  "customerId": "12345",
  "customerName": "John Doe",
  "mobileNumber": "1234567890"
}

### Fetch Account Details

```http
      GET http://localhost:8072/bankcorp/accounts/api/fetch?mobileNumber={mobileNumber}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `mobileNumber`      | `string` | **Query**. Customer's mobile number (10 digits). |

### Update Account Details

```http
    PUT http://localhost:8072/bankcorp/accounts/api/update
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `customerDTO`      | `object` | **Body**. Customer details for update. |

### Request Body Example:
{
  "customerId": "12345",
  "customerName": "John Doe",
  "mobileNumber": "1234567890"
}

### Delete Account Details

```http
    DELETE http://localhost:8072/bankcorp/accounts/api/delete?mobileNumber={mobileNumber}

```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `mobileNumber`      | `string` | **Query**. Customer's mobile number (10 digits). |

### Get Build Information

```http
    GET http://localhost:8072/bankcorp/accounts/api/build-info
```

### Get Java Version

```http
   GET http://localhost:8072/bankcorp/accounts/api/java-version
```

### Get Contact Info

```http
     GET http://localhost:8072/bankcorp/accounts/api/contact-info
```


## Card Controller APIs

### Create Card

```http
POST http://localhost:8072/bankcorp/cards/api/create?mobileNumber={mobileNumber}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `mobileNumber` | `string` | **Query**. Customer's mobile number (10 digits). |

### Fetch Card Details

```http
GET http://localhost:8072/bankcorp/cards/api/fetch?mobileNumber={mobileNumber}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `mobileNumber` | `string` | **Query**. Customer's mobile number (10 digits). |

#### Update Card Details

```http
PUT http://localhost:8072/bankcorp/cards/api/update
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `cardDTO`      | `object` | **Body**. Card details for update. |

#### Request Body Example:


{
  "cardId": "56789",
  "cardType": "Debit",
}

#### Update Card Details

```http
DELETE http://localhost:8072/bankcorp/cards/api/delete?mobileNumber={mobileNumber}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `mobileNumber`      | `string` | **Query**. Customer's mobile number (10 digits). |

### Get Build Information

```http
    GET http://localhost:8072/bankcorp/cards/api/build-info
```

### Get Java Version

```http
   GET http://localhost:8072/bankcorp/cards/api/java-version
```

### Get Contact Info

```http
     GET http://localhost:8072/bankcorp/cards/api/contact-info
```


## Loan Controller APIs

### Create Loan

```http
POST http://localhost:8072/bankcorp/loans/api/create?mobileNumber={mobileNumber}
```


| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `mobileNumber` | `string` | **Query**. Customer's mobile number (10 digits). |

#### Fetch Loan Details



```http
GET http://localhost:8072/bankcorp/loans/api/fetch?mobileNumber={mobileNumber}
```


| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `mobileNumber` | `string` | **Query**. Customer's mobile number (10 digits). |

#### Update Loan Details



```http
PUT http://localhost:8072/bankcorp/loans/api/update
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `loanDTO`      | `object` | **Body**. Loan details for update. |

#### Request Body Example:


{
  "loanId": "56789",
  "loanType": "Home",
}

#### Delete Loan Details

```http
DELETE http://localhost:8072/bankcorp/loans/api/delete?mobileNumber={mobileNumber}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `mobileNumber`      | `string` | **Query**. Customer's mobile number (10 digits). |

### Get Build Information

```http
    GET http://localhost:8072/bankcorp/loans/api/build-info
```

### Get Java Version

```http
   GET http://localhost:8072/bankcorp/loans/api/java-version
```

### Get Contact Info

```http
     GET http://localhost:8072/bankcorp/loans/api/contact-info
```
## Appendix

### Using Helm Charts for Kubernetes Deployment

You can use Helm charts to streamline the deployment of your project in a Kubernetes environment. Helm is a package manager for Kubernetes applications, allowing you to define, install, and upgrade even the most complex Kubernetes applications.

#### Prerequisites

Before using Helm, make sure you have the following installed:

1. **Kubernetes Cluster:** Ensure you have a running Kubernetes cluster.

2. **Helm:** Install Helm by following the instructions in the [official Helm documentation](https://helm.sh/docs/intro/install/).

#### Deploying the Project with Helm

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/DraganovTs/mc_bank_app.git
   cd helm

2. **Install the Helm keycloak Chart:**
   ```bash
    helm install keycloak keycloak


3. **Install the Helm kafka Chart:**
   ```bash
    helm install kafka kafka


4. **Install the Helm loki Chart:**
   ```bash
    helm install loki grafana-loki



5. **Install the Helm tempo Chart:**
   ```bash
     helm install tempo grafana-tempo

    
6. **Install the Helm prometheus Chart:**
   ```bash
    helm install prometheus kube-prometheus

    
7. **Install the Helm grafana Chart:**
   ```bash
    helm install grafana grafana


8. **Install the kubernetes discovery server:**
   ```bash
    cd kubernetes
    kubectl install kubernetes-discoveryserver.yml

8. **Install the Helm microservices Chart:**
   ```bash
    cd helm/environments
    helm install bancorp prod-env

At this point everything should be up and running!

## Setting up Keycloak Client with Client Credential Grant Type and Assigned Roles

## 1. Login to Keycloak:
   - http://localhost:80
   - Open your Keycloak admin console in a web browser.
   - Log in with your administrator credentials.
   - username: user
   - password: password

## 2. Use MASTER Realm:
   - Use default Keycloak realm.
   

## 3. Create a Client:
   - Inside your realm, go to the "Clients" section in the left menu.
   - Click "Create" to add a new client.
   - Fill in the necessary information for your client (e.g., `bankcorp-microservices`).
   - Set the Access Type to confidential.
   - Save the client.

## 4. Configure Client Credentials Grant Type:
   - In the "Settings" tab of your client, set Direct Access Grants Enabled to ON.
   - Under the "Service Account Roles" tab, assign the roles `ACCOUNT`, `CARDS`, and `LOANS` as needed.

## 5. Get Client Credentials:
   - Go to the "Credentials" tab for your client.
   - Note the Secret. This is the client secret that will be used to obtain tokens.

---

Now, your Keycloak client is set up to use the client credential grant type and has been assigned the specified roles. When your microservices use this client to obtain tokens, they can use these tokens to access resources based on the assigned roles.

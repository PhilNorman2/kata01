## Kata01 API

Spring Boot application using Kotlin and MySQL

### Prerequisites

* Java JDK(versions 8 and up)
* Maven - tested with 3.8.3
* MySQL - tested with 8.0.25

### API application Initialization

After cloning the repo, navigate to /kato01 and enter:

mvn spring-boot:run
to load packages, build, amd run

### Using the API

The API runs at this host locally: http://localhost:8080

The entity for the api is subcribers as in

http://localhost:8080/api/subscribers

POST body example:

```
{
    "firstName": "Ringo",
    "city": "Liverpool",
    "addedDate": "2021-11-17"
}
```

GET subcriber by id

http://localhost:8080/api/subscribers/{id}

### Testing

A few mockMVC test cases are written, navigate to project directorty and run:

mvn test







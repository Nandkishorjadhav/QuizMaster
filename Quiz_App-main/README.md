# Spring Boot Quiz App 


## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Database Setup](#database-setup)


## Introduction

Welcome to the Spring Boot Quiz App backend! This application provides the backend services for a quiz application. It allows you to manage quizzes, questions, and user responses.

## Features

1. **Quiz Management:** Create, read, update, and delete quizzes.
2. **Question Management:** Add, edit, and remove questions within quizzes.
3. **User Responses:** Capture and evaluate user responses to quiz questions.


## Technologies Used

- **Spring Boot:** The primary framework for building the backend.
- **MySQL:** The database used to store quiz and question data.
- **Spring Data JPA:** Java ORM for mapping objects to databases with features.

## Database Setup

1. Install MySQL and create a new database.
2. Update the `application.properties` file with your database configuration.

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

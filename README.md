
# 🎯 QuizApp - Sharpen Your Skills with Fun Quizzes

**QuizApp** is a full-stack web application that allows users to test their knowledge across programming topics like Java, JavaScript, SQL, Python, C++, and more.  
It provides a smooth and interactive user experience with quizzes, real-time performance tracking, and beautiful UI animations—all built with **Spring Boot**, **PostgreSQL**, and modern frontend technologies.

Whether you're preparing for coding interviews or just want to learn daily, QuizApp is your perfect learning buddy! 🧠🚀

---

## 🌟 Features

- 🔐 **User Authentication** – Login/SignUp with validation
- 🧠 **Take Quizzes** – Attempt categorized questions by language and difficulty
- 📊 **View Progress** – Graphs for score history and subject performance (Chart.js)
- 📝 **User Dashboard** – Track quiz stats like attempts and average score
- 🧾 **Edit Profile** – Update your name, email, or role easily
- 📈 **View Full Progress** – Interactive charts with smooth transitions
- 💡 **Daily Tips** – Get motivational and study tips every day
- ✅ **Responsive Design** – Looks great on all screen sizes

---

## ⚙️ Setup Overview

To get started with QuizApp, follow these steps:

1. **Clone the repository** to your system.
2. **Set up PostgreSQL** and create a database named `questionDB`.
3. **Insert quiz questions** into the database (use sample `INSERT INTO` statements).
4. **Configure Spring Boot backend** with your DB credentials.
5. **Run the backend** using Maven or your IDE.
6. **Launch the frontend** by opening `index.html` in your browser.

Make sure PostgreSQL is running and accessible, and your backend is connected correctly.

---

## 🧪 Test Credentials

You can register as a new user, or use these credentials (if seeded):

- **Username:** testuser  
- **Password:** test123

---

## 📁 Project Structure

quizapp/ │ ├── backend/ │ ├── controller/ │ ├── model/ │ ├── repository/ │ ├── service/ │ └── QuizAppApplication.java │ ├── frontend/ │ ├── index.html │ ├── login.html │ ├── signup.html │ ├── dashboard.html │ ├── quiz.html │ └── styles.css │ └── README.md


---

## 🧰 Tech Stack

- **Frontend:** HTML, Tailwind CSS, JavaScript, Chart.js  
- **Backend:** Java, Spring Boot  
- **Database:** PostgreSQL  
- **Other:** Chart.js for graphs, LocalStorage for session

---

## 🧑‍💻 Contributing

Contributions are welcome!

1. Fork the project
2. Create a feature branch
3. Push your changes
4. Open a pull request
---

> 💡 *“Practice is the key to mastery. Take at least one quiz a day to stay sharp!”*

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


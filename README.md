# Khana Khazana

_A_ ___OLA___ ___Group9___ _Capstone_ _Porject_ _For_ _Food_ _Delivery_ _Application_

![TravisCI](https://img.shields.io/badge/travis%20ci-%232B2F33.svg?style=for-the-badge&logo=travis&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  ![MySQL](	https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)![SpringBoot](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)  ![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white) ![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) ![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)

[![Build Status](https://app.travis-ci.com/gptshubham595/OLAGRP9.svg?branch=main)](https://app.travis-ci.com/gptshubham595/OLAGRP9)

![JDK](https://img.shields.io/static/v1?label=JDK%20Version&message=1.8&color=green)
![Swagger API](https://img.shields.io/static/v1?label=Swagger&message=Enabled&color=green)
![License](https://img.shields.io/static/v1?label=LICENSE&message=Creative%20Commons%20Zero%20v1.0%20Universal&color=red)
## Overview

This is a capstone project delivering a sample food delivery with backend system using spring boot and frontend usiong react. This is a system designed in Spring Boot Microservices architecture to provide REST APIs for food ordering and delivery system. KhanaKhazana is a full-featured FoodOrdering app. Using this application one can visualize various available features like authentication, user ordering, managing of the restaurants, admin controlling, coupons usage, searching food or restaurants, etc.

## Team Structure

| ```  Name ```     |```GitUsername```|```Operations```|
| ----------------- | --------------- | -------------- |
|```Shubham Gupta```| gptshubham595   |``` Backend ``` |
| Pankaj Verma      | Pankaj734       |``` Backend ``` |
| Apoorv Lodhi      | apoorvlodhi-io  |``` Backend ``` |
| Aman Kumar        | huamanoid       |``` Backend ``` |
| Amish Anand       | inferno-afk     |``` Backend ``` |
| Shubham Joshi     | shubhamjoshi98  |``` Backend ``` |
| Akshay Choudhary  | akshay2613      |``` Backend ``` |
| ----------------- | --------------- | -------------- |
| Aditya Bhadoriya  | Aditya17072000  |    Frontend    |
| Shridam Mahajan   | shridam1207     |    Frontend    |


## Guidelines

**BACKEND**
 - To run the application on localhost 
    1. Import git repo via this command
      ```
        git clone https://github.com/gptshubham595/OLAGRP9.git
      ```
    2. ``` cd backend\KhanaKhazana ```  
    3. Open and Build the app using IntelliJ as a Maven Project
    4. Server starts on the the port **3200**
    5. For swagger api hit at ___localhost:3200/swagger-ui.html___

**FRONTEND**
- To run the application on localhost 
    1. Import git repo via this command
      ```
        git clone https://github.com/gptshubham595/OLAGRP9.git
      ```
    2. ``` cd frontend ```  
    3. Open and Build the app using command ``` npm start ```
    4. Server starts on the the port **3000**
    

## Deployments
  ### Website deployed at : http://khanakhazana.rf.gd/
  
  ### Heroku
   1. Backend
     - https://khana-khazana-backend.herokuapp.com/
   2. Frontend
     - http://khana-khazana-freontend.herokuapp.com/
  ### MYSQL DATABASE
   1. Hosting done at https://remotemysql.com/
 
## ALL API ENDPOINTS SWAGGER UI
 - [SWAGGER API LIST](https://khana-khazana-backend.herokuapp.com/swagger-ui.html)

## Development environment

- **MySQL** is running on *https://remotemysql.com*.
- **Mongo DB** is running on **atlas**.
- **Spring Boot** is used for fast REST API development and independant deployment.

## Maven Libraries used
 - [Spring boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/2.7.2) : TO create a spring boot application
 - [Spring boot Starter Security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security/2.7.2) : To add salt and pepper encrytption in registeration 
 - [Swagger](https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui) : To generate api endpoints list
 - [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok) : To auto generate getter and setter
 - [Commons-Codec](https://mvnrepository.com/artifact/commons-codec/commons-codec) : To encode and decode to base64
 - [Mysql COnnector](https://mvnrepository.com/artifact/mysql/mysql-connector-java) : To connect spring boot application to mysql database
 - [JPAConnector](https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa) : TO perform prebuild mysql queries 
 - [Commons-Lang3](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3) : To generate random alphanumeric invoice and transaction Id
 
 
 ## Features Implemented
 
   1. Users

    - Registeration & Sign In 
    - Session Token generation
    - Order Placing
    - Invoice Generation
    - Coupons
    - User profile Section
    - Wild card Search food and restaurants
   
   2. Admins

    - manage Users orders
    - Get All Users and Managers Data
    - Add coupons 
    - Ban Users 
   
   3. Manager

    - Add Restaurants
    - Add Food Items
    - Modify Food Items
    
    
 
 ## System Architecture Diagram
 
 <img src="./Diagrams/System%20Diagram.png" width="800" height="400" />

## Class Diagram
<img src="./Diagrams/Class%20Diagram.png" width="800" height="400" />
 
## User Flow Diagram
 <img src="./Diagrams/Flow%20Diagram.png" width="600" height="600" />

## DB Schema
<img src="./Diagrams/DB%20Schema.png" width="600" height="400" />
 
 
 ## Communication

You can use IRC web interface on [https://gitter.im/KhanaKhazana/](https://gitter.im/KhanaKhazana/).

Our other sources of communications include

- Email: gptshubham595@gmail.com 


## LEGAL & DISCLAIMER

Please refer to [COPYING](LICENSE).


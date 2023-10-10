# Muvz
Projeto utilizado para vaga Muvz.


Java 17.0.8
MySQL 8
Spring Boot 3.1.4


Migration:
CREATE DATABASE user

CREATE TABLE user.user (
   id int AUTO_INCREMENT,
   name varchar(255),
   PRIMARY KEY (id)
);


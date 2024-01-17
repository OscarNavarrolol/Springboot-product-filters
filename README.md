# Spring Boot Project with Search, MySQL, Thymeleaf, and Validations

This is a sample Spring Boot project that includes a search filter, integration with a MySQL database, basic design using HTML and Thymeleaf, and validations using Spring Data JPA. Additionally, DevTools and Spring Web have been incorporated to facilitate development.

## Requirements

Make sure you have the following installed:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MySQL](https://www.mysql.com/)

## Database Configuration

1. **Creating the MySQL Database:**
   - Open your MySQL client and execute the following command to create a new database. You can name it as you prefer, for example, `springbootdb`:

     ```sql
     CREATE DATABASE springbootdb;
     ```

   - Make sure to select the new database before proceeding:

     ```sql
     USE springbootdb;
     ```

2. **Configuration in `application.properties`:**
   - Open the `src/main/resources/application.properties` file and update the configurations with your credentials and connection details. Use the information from your MySQL server and access credentials:

     ```properties
     spring.datasource.url=jdbc:mysql://your_server:your_port/springbootdb
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.jpa.hibernate.ddl-auto=update
     ```

     Make sure to replace `your_server`, `your_port`, `your_username`, and `your_password` with the correct values.

     ![Database Configuration](https://i.postimg.cc/d1rJCd0M/Whats-App-Image-2024-01-16-at-10-20-56-PM.jpg)

With these configurations, your Spring Boot application will be ready to connect to the MySQL database you have created. Ready to start development!

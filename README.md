
# green-space-project

## Authors

- [@Ian Zhao](https://github.com/ian-jinkun)
- [@Zexin Sun](https://github.com/zsun005/store)

## Program Introduction
The project is web-based membership management system. Members pay an annual fee to receive services from the business. This system will allow members to access their profile and renew their membership online.

This project is a web-based management system for with Springboot framework as backend service with Java. For frontend, we use bootstrap as framework, designed and implement web page with HTML, CSS, JQuery, and JavaScript. With Ajax, web page can send and retrieve data from a backend service by controllers. For the database, we used mysql manage and stored data and information. We also used Mybatis technology in our persistence layers. 

### System development and operation environment
Membership management system development required environment and related software are introduced.

- Operating system: Mac OS/Windows 

- Java development package: JDK 8

- Project management tool: Maven 3.6.3

- Project development tool: IntelliJ IDEA 2021.3X64

- Database: MySQL

- Browser: Google Chrome

- Server architecture: Spring Boot 2.6 + MyBatis 2.1.4 + BootStrap 5.1.3 + AJAX

## Features

- User login
- Register as an email account
- Send an email verification code to register an account
- Change the password
- Log in to the home page
- User profile management


## Configure and run the project
### Running Projects

Find the entry class for the project (decorated by the @SpringBootApplication annotation) and run the launch class; Startup process If the console outputs Spring graphics, the startup is successful.

```java
package com.company.greenspaceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.company.greenspaceproject.dao")
public class GreenSpaceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenSpaceProjectApplication.class, args);
    }

}
```

### Configuration 
Add the configuration for the data source in the application.properties file under the Resources folder. Includes connect database, required mailbox use.
```xml
spring.datasource.url=jdbc:mysql://rm-0xi33417847c8tvrq3o.mysql.rds.aliyuncs.com:3306/test_1?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=sunzexi
spring.datasource.password=qwe123QWE!@#

spring.mail.host=smtp.qq.com
spring.mail.username=879154872@qq.com
spring.mail.password=iynqwnubqlqlbcfj
spring.mail.default-encoding=UTF-8
spring.mail.port=465
mail.fromMail.addr=879154872@qq.com
spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
spring.mail.properties.mail.debug=true
```

# Springboot Exception Handling Example
**Template for Springboot + Spring Security + jQuery Ajax, using Gradle build tool.**

@ControllerAdvice annotation help the Controller. it modularize common functions of Controllers.

ServerProperties class`s subclass is can add custom error page for HTTP error.

We distinguish between JSON requests and HTML requests using @RequestMapping annotation.

----------------------
## 1. Technologies used
* Springboot 1.5.9.RELEASE
* Spring 4.3.13.RELEASE
* Spring Security 4.2.3.RELEASE
* tomcat-embed-jasper-8.5.2
* jstl-1.2.jar
* jQuery 3.2.1
* Gradle 4.2.1

## 2. To run this project in local
```bash
git clone https://github.com/CheolHoJung/springboot-exception-handling-example.git
gradle bootRun
```
Access http://localhost:8080/

## 3. To import this project into Eclipse
```
1. import Projects from git
2. convert to gradle
```

## 4. Note
* If you wanna see explanation for this example, visit to  [my blog post](http://plposer.tistory.com/68). (this post written in Korean.)

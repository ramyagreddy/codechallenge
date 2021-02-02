#Code Challenge
Code Challenge is a web application built in Java using Spring Boot 2.4.2 framework.


## System Requirements
* Java 8
* Maven Version: 3.6.3
* Eclipse IDE for Enterprise Java Developers (Version: 2020-12 (4.18.0))
* Apache Tomcat v 9.0


## How to build this project
Spring Boot Maven plugin is used which has the ability to automatically deploy this web application in an embedded application server (Apache Tomcat). Apache Tomcat runs on 8081 port as per the configuration in application.properties file. If 8081 port is already in use, port number can be modified in application.properties file (under /src/main/resources)

Following the below steps to download the source code from git repository on ###
1. Download source code from git using link ######
2. Extract source code to a folder location
3. Open command prompt in this folder location where source code is downloaded
4. Enter below command to clean the project
	`mvn clean`
5. Enter below command to build this project to generate a deployable WAR file
	`mvn install`
	**Executing Tests**
	Test class should run executing all the unit test cases. Please note the successful tests run and no failures.
6. Project should build successfully with no errors. 
	Check the target/ folder which is .m2 repository on local. It should now contain the deployable WAR file **codechallenge-1.0.0.war**
	
## How to run this project	
***You could either deploy this war file on Apache Tomcat installed on local server.
(or)
***You can import this maven project into eclipse and run the project using Run configuration for Spring Boot. Follow below steps to run the application on embedded Tomcat server provided by Spring boot.
1.  

#complete this --------------->

## Engineering Methodology

Tried to follow SOLID design principles for this web API development
*Single Responsibility Principle – a module should only have one reason to change: Service implementation will have only 1 reason to change, i.e, it only does conversion of a number to a Roman numeral.
*Open/Closed Principle - Open for extension, closed for modifications: This application could be extended to include any other algorithms (packaging structure is open for extension)
*Interface Segregation Principle – don’t depend on what you don’t need

Combination of Test driven development (TDD) and Spiral development methodologies are used for this web API development.

***Test Driven Development (TDD)
TDD cycle defines:
1. Write a test
2. Make it run.
3. Change the code to make it right i.e. Refactor.
4. Repeat process.

Following steps define how to perform TDD test,
1. Add a test.
2. Run all tests and see if any new test fails.
3. Write some code.
4. Run tests and Refactor code.
5. Repeat.

***Spiral Development methodology:
Each trip around the spiral traverses four basic quadrants: 
1. determine objectives, alternatives, and constraints of the iteration 
2. Evaluate alternatives; Identify and resolve risks 
3. Develop and verify deliverables from the iteration
4. Plan the next iteration.

## Testing Methodology

Junit for unit testing the service implementation for RomanNumeralsService (that includes a method to convert a number to a Roman numeral).
Junit test cases are written to test all edge cases, valid and invalid inputs.

Below steps are followed to perform TDD test,
1. Add a test.
2. Run all tests and see if any new test fails.
3. Write some code.
4. Run tests and Refactor code.
5. Repeat.


## Packaging Layout

Packaging: War

**Packaging structure**
*algorithm.core: Contains the Servlet initializer for Spring Boot framework and Spring Boot application with the main method
*algorithm.core.controller: Includes the controller class for using RomanNumeralsService to implement API to convert an integer to a Roman numeral
*algorithm.core.service: Includes the service interface to include methods for invoking web API
*algorithm.core.service.impl: Includes the service implementation for RomanNumeralsService
*algorithm.core.util: Includes the utility class that provides a TreeMap mapping of values to Roman numeral symbols; Also includes Constants class.
*algorithm.core.test: Includes test classes for unit testing service implementation.


## Dependency Attribution

Uses below dependencies:

1. Junit for unit testing
2. Tomcat server embedded 
3. Spring Boot Actuator for Metrics and monitoring support
4. Spring Boot Maven Plugin for build, test, packaging code
	
## Metrics 

Spring Boot Actuator provides dependency management and auto-configuration for Micrometer, an application metrics facade that supports numerous monitoring systems like JMX, New Relic etc.

Actuator endpoints let you monitor and interact with your application. Spring Boot includes a number of built-in endpoints. Each individual endpoint can be enabled or disabled and exposed (made remotely accessible) over HTTP or JMX. An endpoint is considered to be available when it is both enabled and exposed.

Spring Boot provides a metrics endpoint that can be used diagnostically to examine the metrics collected by an application. The endpoint is enabled but not exposed to web by default (though exposed to JVM).

**How to access metrics**
Navigating to http://localhost:8081/actuator/metrics displays a list of available meter names. You can drill down to view information about a particular meter by providing its name as a selector, e.g. http://localhost:8081/actuator/metrics/jvm.memory.max

You can also add any number of tag=KEY:VALUE query parameters to the end of the URL to dimensionally drill down on a meter, e.g. /actuator/metrics/jvm.memory.max?tag=area:nonheap

** Supported Metrics**
Spring Boot registers the following core metrics when applicable:

*JVM metrics, report utilization of:
	Various memory and buffer pools
	Statistics related to garbage collection
	Threads utilization
	Number of classes loaded/unloaded
*CPU metrics
*File descriptor metrics
Logback metrics: record the number of events logged to Logback at each level
Uptime metrics: report a gauge for uptime and a fixed gauge representing the application’s absolute start time
Tomcat metrics
Spring Integration metrics


## Monitoring

**Monitoring over JMX**
Java Management Extensions (JMX) provide a standard mechanism to monitor and manage applications. By default, this feature is not enabled and can be turned on by setting the configuration property spring.jmx.enabled to true. Spring Boot exposes management endpoints as JMX MBeans under the org.springframework.boot domain by default.

Micrometer provides a hierarchical mapping to JMX, primarily as a cheap and portable way to view metrics locally. By default, metrics are exported to the metrics JMX domain. The domain to use can be provided using:
management.metrics.export.jmx.domain=com.code.codechallenge

**Monitoring over HTTP**
Spring Boot Actuator auto-configures all enabled endpoints to be exposed over HTTP. The default convention is to use the id of the endpoint with a prefix of /actuator as the URL path. For example, health is exposed as /actuator/health.
You can access health endpoint at http://localhost:8081/actuator/health which shows application health information.

# Logging

Java Util Logger is used for logging debug, info, warnings or severe error messages in application.

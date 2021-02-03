#Code Challenge
Code Challenge is a web application built in Java using Spring Boot 2.4.2 framework.
This application provides a web API that converts a number to a Roman numeral for all integers between 0 to 3999.

## System Requirements
* Java 8
* Maven Version: 3.6.3
* Eclipse IDE for Enterprise Java Developers - Version: 2020-12 (4.18.0) (Optional - Required only if you are building/deploying using Eclipse)

## How to build and run this project 
You can build and run this project using Maven or Eclipse.

Please note: Apache Tomcat server runs on 8081 port as per the configuration in application.properties file. If 8081 port is already in use, port number can be modified in application.properties file (under /src/main/resources)

### Downloading source code
Follow the below steps to download the source code from the git repository.
1. You can clone the git repository from github using the below link

	https://github.com/ramyagreddy/codechallenge.git
	
(or)

2. Simply download the source code as .zip file using "Download Zip" option in Github to a localfolder, say - "codechallengerepo"

### How to build and run using Maven (Option 1)
Spring Boot Maven plugin included in this maven project is used which has the ability to automatically deploy this web application in an embedded application server (Apache Tomcat). 
1. Open command prompt in the folder where source code is downloaded (say folder "codechallengerepo").
2. Enter below command to clean the project; package and build a WAR file
	`mvn clean package`
	This command will also execute all the test classes running all test cases. Please note all the successfully run test cases.
3. Enter below command to deploy the war file on embedded Tomcat server. 
	`java -jar target/codechallenge-1.0.0.war`
	
You can access the web API using below link ({integer} could be any integer between 0 to 3999)

	http://localhost:8081/romannumeral?query={integer}
	
### How to build and run using Eclipse (Option 2 - Alternate to Option 1)
***You can import this maven project into eclipse and run the project using Run configuration for Spring Boot. Spring Boot Maven plugin is used which has the ability to automatically deploy this web application in an embedded application server (Apache Tomcat). 
Follow below steps to run the application on embedded Tomcat server provided by Spring boot.

1. Import the project source code into eclipse using File -> Import -> Existing Maven projects
2. Browse to select the root directory folder of the extracted source code folder ("codechallengerepo")
3. Select pom.xml file to import the maven project. Select Finish to complete importing.  
4. Make sure "Build Automatically" is selected under Project menu in eclipse.
5. Select Project -> Clean to clean and build project ("Start a build immediately" option is auto-selected)
6. Select project "codechallenge" in the "Clean" pop-up window and select clean. Project will be cleaned and build will be completed.
7. Select project "codechallenge" and select Run -> Run Configurations
8. Select Spring Boot App and click on "New launch configuration" icon to create a new run configuration.
9. Select project "codechallenge" and main class "algorithm.core.CodeChallengeApplication". 
10. Retain other configurations as default in "Spring boot" tab, "Arguments" tab.
11. Make sure Java 1.8 JRE is selected in JRE tab.
12. Add source folder "codechallenge" in Source tab.
13. Apply changes and run. CodeChallenge web application should be started successfully and Tomcat server should be started on 8081 port.
 
You can access the web API using below link ({integer} could be any integer between 0 to 3999)

	http://localhost:8081/romannumeral?query={integer}

## Engineering Methodology

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

Attempted to adhere to SOLID design principles for this web API development.
* Single Responsibility Principle – a module should only have one reason to change: Service implementation will have only 1 reason to change, i.e, it only does conversion of a number to a Roman numeral.
* Open/Closed Principle - Open for extension, closed for modifications: This application could be extended to include any other algorithms (packaging structure is open for extension)
* Interface Segregation Principle – Don’t depend on what you don’t need

## Testing Methodology

Junit for unit testing the service implementation for RomanNumeralsService (that includes a method to convert a number to a Roman numeral).
Junit test cases are written to test all edge cases, valid and invalid inputs.

Below steps are followed to perform TDD test:
1. Add a test.
2. Run all tests and see if any new test fails.
3. Write some code.
4. Run tests and Refactor code.
5. Repeat.


## Packaging Layout

Packaging: War

**Packaging structure**
* algorithm.core: Contains the Servlet initializer for Spring Boot framework and Spring Boot application with the main method
* algorithm.core.controller: Includes the controller class for using RomanNumeralsService to implement API to convert an integer to a Roman numeral
* algorithm.core.service: Includes the service interface to include methods for invoking web API
* algorithm.core.service.impl: Includes the service implementation for RomanNumeralsService
* algorithm.core.util: Includes the utility class that provides a TreeMap mapping of values to Roman numeral symbols; Also includes Constants class.
* algorithm.core.test: Includes test classes for unit testing service implementation.

## Dependency Attribution

This web application uses below dependencies:

1. Junit for unit testing
2. Tomcat server embedded in Sprint Boot
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

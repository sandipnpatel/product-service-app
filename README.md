# product-service-app

## Build Project(Java 11)
mvn clean install

## Start Application

### Using main() method
Run 'ProductServiceApplication.main()' method.

**NOTE**
1. To compile with Intellij Idea, you need to install LOMBOK plugins.

### Using maven
Run 'mvn spring-boot:run' from project's root directory using command prompt.

### Using command prompt
Execute command 'java -jar target/product-service-app-2008.00.00-SNAPSHOT.jar' from project root directory

## Highlights of Production Code
1. Simple and self documented rest api endpoints.
2. Clean code.
3. Adhere to SOLID and KISS principles.
4. Latest spring-boot release version(2.3.2.RELEASE) and latest java LTS version(Java 11).
5. In-Memory database H2 and integrated DB version management Flyway.
6. Self documented Swagger implementation [swagger-ui.html](http://localhost:8080/swagger-ui.html) for easy of reading contract and manual endpoint testing.
7. Integration of 'spring-cloud-starter-sleuth' for log tracing in clustered/distributed environment.

## Highlights of Testing 
1. Good Testing coverage of Class, methods, lines and use cases at unit level and integration level.
2. Spoke based Black box testing framework(ProductServiceApplicationSpec.groovy). Cover all the contract testing scenarios.
3. ArchUnit framework for project architecture testing(https://www.archunit.org/).
4. Jacoco Test coverage [index.html](file:///target/site/jacoco/index.html).
5. OWASP  Vulnerabilities report: [dependency-check-report.html](file:///target/dependency-check-report.html)

## What is next?
1. Enhancement of Domain model with detail implementation of every product groups and products.
2. Implementation of Spring Security with JWT and OAUTH2.
3. Rest endpoint compliant with Richardson Maturity Model Level-3(Hypermedia Controls) using 'spring-boot-starter-hateoas'.
4. Integration of Frontend and internationalization.
5. BDD testing using cucumber.
6. Performance testing.
7. CI/CD pipeline(Jenkins or Azure DevOps).
8. Integration of SonarCube analysis.
9. Containerization and Integration with Orchestration tool.
10. Integration with Kibana or Dynatrace.
11. Java-doc.

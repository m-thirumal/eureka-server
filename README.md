# Eureka-server 

* [Eureka Server](http://localhost:8761)


### Dependent project

* [Spring boot admin server](https://github.com/M-Thirumal/spring-boot-admin-server)

# To Create jar

	mvn clean install
	
	mvn clean package -DskipTests=true

# Run as jar from terminal

	java -jar target/eureka-server-0.0.1-SNAPSHOT.jar
	
	java -jar -Dspring.profiles.active=DEV-PRIMARY target/eureka-server-0.0.1-SNAPSHOT.jar
	
	java -jar -Dspring.profiles.active=DEV-SECONDARY target/eureka-server-0.0.1-SNAPSHOT.jar
	
	java -jar -Dspring.profiles.active=DEV-TERTIARY target/eureka-server-0.0.1-SNAPSHOT.jar

	
### Swagger UI

[http://localhost:8761/swagger-ui/index.html](http://localhost:8761/swagger-ui/index.html)

### Credentials

	thirumal:thirumal
	
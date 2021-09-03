# Eureka-server 

* [Eureka Server](http://localhost:8761) high availability (HA) for Production


<img src="HA-eureka.png" alt="HA-eureka.png" width="500" height="400"/>

### Dependent project

* [Spring boot admin server](https://github.com/M-Thirumal/spring-boot-admin-server)

## To Create jar

	mvn clean install
	
	mvn clean package -DskipTests=true

## Run as jar from terminal

	java -jar target/eureka-server-0.0.1-SNAPSHOT.jar
	
	java -jar -Dspring.profiles.active=DEV-PRIMARY target/eureka-server-0.0.1-SNAPSHOT.jar
	
	java -jar -Dspring.profiles.active=DEV-SECONDARY target/eureka-server-0.0.1-SNAPSHOT.jar
	
	java -jar -Dspring.profiles.active=DEV-TERTIARY target/eureka-server-0.0.1-SNAPSHOT.jar
	
### Start up at OS boot

Add the below line in `corn -e`
	
	@reboot /{path-to-eureka-server-script}/eureka-server.sh {ENV}

Example:
	
	@reboot /home/thirumal/git/eureka-server/eureka-server.sh DEV-PRIMARY
	
Note: Add `cd /path-to-repo` to the shell script (1'st line)
	
### Replica 

* Make sure `eureka.instance.hostname: ` is same as `eureka.client.serviceUrl.defaultZone`. Check how it's configured in `PRO environment`
* If you want some of cluster to be independent set `eureka.client.fetchRegistry` is `false`. That is, don't want to fetch details from other cluster. Check `UDEV` environment `UDEV-SECONDARY`
	
### Swagger UI

[http://localhost:8761/swagger-ui/index.html](http://localhost:8761/swagger-ui/index.html)

### Credentials

	thirumal:thirumal

### Extras - PROMETHEUS(Run the following docker command in the `prometheus.yml`file directory.


    [http://localhost:8761/actuator/prometheus](Prometheus actuator endpoint)    

    docker run -d -p 9090:9090 -v /Users/thirumal/git/eureka-server/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
	

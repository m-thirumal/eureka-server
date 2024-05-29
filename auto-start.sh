cd /home/ubuntu/git/eureka-server
nohup java -jar -Dspring.profiles.active=DEV-PRIMARY target/eureka-server-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &

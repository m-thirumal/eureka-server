mvn clean package -DskipTests=true
echo 'starting application'
appName="eureka-server-0.0.1-SNAPSHOT.jar"
echo 'App Name:' $appName
pkill -f $appName 
java -jar target/$appName

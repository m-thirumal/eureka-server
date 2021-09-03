#! /bin/bash
#title           :eureka-server.sh
#description     :This script create eureka-server jar and run on the given environment (Default - DEV).
#author		     :Thirumal(m.thirumal@hotmail.com)
#date            :03/09/2021
#version         :0.1
#usage		     :./eureka-server.sh DEV-PRIMARY in LINUX & sh eureka-server.sh DEV-PRIMARY in MAC OS
#notes           :Install Vim
echo "Git Pull"
git pull
echo "Git pull successful"
mvn clean package -DskipTests=true
echo 'starting application'
appName="eureka-server-0.0.1-SNAPSHOT.jar"
echo 'App Name:' $appName
#pkill -f $appName 
nohup java -jar -Dspring.profiles.active=$0 target/$appName >& /dev/null &

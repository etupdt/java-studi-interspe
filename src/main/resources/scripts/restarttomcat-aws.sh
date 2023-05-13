#!/bin/bash

log=/var/log/deploy/restarttomcat

echo "debut restarttomcat $(date)"

echo 'pwd du script'
pwd

echo 'stat restarttomcat-aws.sh'
stat "/tmp/restarttomcat-aws.sh"

war='/opt/tomcat/webapps/yourbook.war'

sudo aws s3 cp s3://studi-interspe/tomcat/context.xml /opt/tomcat/conf/

database=$(sudo aws secretsmanager get-secret-value --secret-id 'mysql-yourbook' --query 'SecretString' --output text --region 'eu-west-3' | jq . -r)

host=$(echo $database | jq .DATABASE_HOST -r)
port=$(echo $database | jq .DATABASE_PORT -r)
user=$(echo $database | jq .DATABASE_USER -r)
password=$(echo $database | jq .DATABASE_PASSWORD -r)
dbname=$(echo $database | jq .DATABASE_DBNAME -r)
keystorepassword=$(echo $database | jq .KEYSTORE_PASSWORD -r)

sudo sed -i "s/{{DATABASE_HOST}}/${host}/g" "/opt/tomcat/conf/context.xml"
sudo sed -i "s/{{DATABASE_PORT}}/${port}/g" "/opt/tomcat/conf/context.xml"
sudo sed -i "s/{{DATABASE_USER}}/${user}/g" "/opt/tomcat/conf/context.xml"
sudo sed -i "s/{{DATABASE_PASSWORD}}/${password}/g" "/opt/tomcat/conf/context.xml"
sudo sed -i "s/{{DATABASE_DBNAME}}/${dbname}/g" "/opt/tomcat/conf/context.xml"
sudo sed -i 's/<!--<Context path="" docBase=""\/>-->/<Context path="" docBase="yourbook"\/>/g' '/opt/tomcat/conf/server.xml'

echo 'start tomcat et apache'
sudo systemctl start tomcat.service
#sudo systemctl start httpd.service

echo "fin restarttomcat $(date)"

echo 'exit script'
exit 0

#!/bin/bash

log=/var/log/deploy/starttomcat

echo "debut starttomcat $(date)"

echo 'pwd du script'
pwd

echo 'stat starttomcat-aws.sh'
stat "/tmp/starttomcat-aws.sh"

echo 'stop tomcat et apache'
sudo systemctl stop tomcat.service
#sudo systemctl stop httpd.service

echo 'delete yourbook.war'
rm -f /opt/tomcat/webapps/yourbook.war

#echo 'sleep 15'
#sleep 15

echo "fin starttomcat $(date)"

echo 'exit script'
exit 0
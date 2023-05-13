#!/bin/bash

log=/var/log/deploy/tomcat-yourbook.log

echo 'exec restarttomcat.sh' |& sudo tee $log

aws ecr get-login-password --region eu-west-3 | sudo docker login --username AWS --password-stdin 498746666064.dkr.ecr.eu-west-3.amazonaws.com

sudo docker stop tomcat-yourbook |& tee -a $log
sudo docker rm tomcat-yourbook |& tee -a $log

sudo docker image rm 498746666064.dkr.ecr.eu-west-3.amazonaws.com/tomcat-yourbook:latest

sudo docker pull 498746666064.dkr.ecr.eu-west-3.amazonaws.com/tomcat-yourbook:latest |& tee -a $log
sudo docker run -p 8443:8443 -d --name tomcat-yourbook 498746666064.dkr.ecr.eu-west-3.amazonaws.com/tomcat-yourbook |& tee -a $log

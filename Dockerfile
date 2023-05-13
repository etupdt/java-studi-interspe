FROM tomcat:11.0.0-jdk17

SHELL ["/bin/bash", "-c"]

#LABEL maintainer="deepak@softwareyoga.com"

ADD target/context.xml /usr/local/tomcat/conf/
ADD target/server.xml /usr/local/tomcat/conf/
ADD target/studi-keystore.jks /usr/local/tomcat/conf/
ADD target/yourbook.war /usr/local/tomcat/webapps/

EXPOSE 8443 

CMD ["catalina.sh", "run"]

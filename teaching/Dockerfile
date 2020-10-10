FROM frolvlad/alpine-oraclejre8
MAINTAINER tangbao203@163.com

COPY target/teaching-1.0-SNAPSHOT.jar /data/app.jar
ENTRYPOINT ["nohup","java","-Xmx200m","-Xms100m","-jar","/data/app.jar","&"]

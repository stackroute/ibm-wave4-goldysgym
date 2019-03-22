FROM openjdk:11

RUN mkdir /src

WORKDIR /src

ADD target/eurekaServer-0.0.1-SNAPSHOT.jar /src/eureka.jar

EXPOSE 9090

RUN sh -c 'touch /src/eureka.jar'

ENTRYPOINT ["java","-jar","/src/eureka.jar"]


FROM openjdk:11

ADD ./target/enrollment-service-0.0.1-SNAPSHOT.jar /usr/src/enrollment-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "enrollment-service-0.0.1-SNAPSHOT.jar"]
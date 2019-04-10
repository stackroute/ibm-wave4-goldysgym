
FROM openjdk:11

ADD ./target/enrollment-0.0.1-SNAPSHOT.jar /usr/src/enrollment-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "enrollment-0.0.1-SNAPSHOT.jar"]
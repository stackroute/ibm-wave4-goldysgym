
FROM openjdk:11

ADD ./target/program-schedular-0.0.1-SNAPSHOT.jar /usr/src/program-schedular-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "program-schedular-0.0.1-SNAPSHOT.jar"]
FROM openjdk:11

ADD ./target/program-service-0.0.1-SNAPSHOT.jar /usr/src/program-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

EXPOSE 9001

ENTRYPOINT ["java","-jar", "program-service-0.0.1-SNAPSHOT.jar"]
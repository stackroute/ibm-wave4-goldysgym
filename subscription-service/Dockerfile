FROM openjdk:11

ADD ./target/subscription-service-0.0.1-SNAPSHOT.jar /usr/src/subscription-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

EXPOSE 9003

ENTRYPOINT ["java","-jar", "subscription-service-0.0.1-SNAPSHOT.jar"]
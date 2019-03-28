FROM openjdk:11

ADD ./target/admin-service-0.0.1-SNAPSHOT.jar /usr/src/admin-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

EXPOSE 9001

ENTRYPOINT ["java","-jar", "admin-service-0.0.1-SNAPSHOT.jar"]
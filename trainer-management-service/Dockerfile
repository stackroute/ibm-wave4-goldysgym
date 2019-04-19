FROM openjdk:11

ADD ./target/trainer-management-service-0.0.1-SNAPSHOT.jar /usr/src/trainer-management-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

EXPOSE 9004

ENTRYPOINT ["java","-jar", "trainer-management-service-0.0.1-SNAPSHOT.jar"]
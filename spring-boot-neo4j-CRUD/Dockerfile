FROM openjdk:11

ADD ./target/spring-boot-neo4j-CRUD-0.0.1-SNAPSHOT.jar /usr/src/spring-boot-neo4j-CRUD-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

EXPOSE 9003

ENTRYPOINT ["java","-jar", "spring-boot-neo4j-CRUD-0.0.1-SNAPSHOT.jar"]
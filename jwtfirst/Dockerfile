FROM openjdk:11

ADD ./target/jwtfirst-0.0.1-SNAPSHOT.jar /usr/src/jwtfirst-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

EXPOSE 9002

ENTRYPOINT ["java","-jar", "jwtfirst-0.0.1-SNAPSHOT.jar"]
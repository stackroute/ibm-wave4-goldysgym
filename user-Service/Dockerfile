FROM openjdk:11

RUN mkdir /src

WORKDIR /src

ADD target/user-service-0.0.1-SNAPSHOT.jar /src/user-service-0.0.1-SNAPSHOT.jar

EXPOSE 7789

RUN sh -c 'touch /src/user.jar'

ENTRYPOINT ["java","-jar","/src/user-service-0.0.1-SNAPSHOT.jar"]
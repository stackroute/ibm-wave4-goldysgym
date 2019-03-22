FROM openjdk:11

RUN mkdir /src

WORKDIR /src

ADD target/player-service-0.0.1-SNAPSHOT.jar /src/player-service-0.0.1-SNAPSHOT.jar

EXPOSE 7788

RUN sh -c 'touch /src/user.jar'

ENTRYPOINT ["java","-jar","/src/player-service-0.0.1-SNAPSHOT.jar"]
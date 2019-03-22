FROM openjdk:11

RUN mkdir /src

WORKDIR /src

ADD target/configServer-0.0.1-SNAPSHOT.jar /src/centralizedconfig.jar

EXPOSE 8891

RUN sh -c 'touch /src/centralizedconfig.jar'

ENTRYPOINT ["java", "-jar","/src/centralizedconfig.jar"]

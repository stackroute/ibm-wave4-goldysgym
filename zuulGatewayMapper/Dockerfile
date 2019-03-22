FROM openjdk:11

RUN mkdir /src

ADD keystore.p12 /src/keystore.p12

WORKDIR /src

ADD target/zuulGatewayMapper-0.0.1-SNAPSHOT.jar /src/zuul.jar

EXPOSE 8092

RUN sh -c 'touch /src/zuul.jar'

ENTRYPOINT ["java", "-jar","/src/zuul.jar"]
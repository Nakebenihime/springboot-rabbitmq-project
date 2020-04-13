FROM openjdk:12-jdk-alpine
LABEL maintainer="mario-dacosta@hotmail.fr"
EXPOSE 8181
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} rabbitmq-consumer.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/notification","-Djava.security.egd=file:/dev/./urandom","-jar","/rabbitmq-consumer.jar"]

#USE MAVEN FOR BUILD STAGE
#FROM maven:3.6.2-jdk-11 AS MAVEN-BUILD
#COPY src /build/src/
#COPY pom.xml /build/
#WORKDIR /build/
#RUN mvn clean package
#
#FROM openjdk:12-jdk-alpine
#WORKDIR /application/
#COPY --from=MAVEN-BUILD /build/target/rabbitmq-consumer-0.0.1-SNAPSHOT.jar /application/
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/rabbitmq-consumer-0.0.1-SNAPSHOT.jar"]

##USE ALPINE FOR BUILD STAGE
#FROM alpine:3.11.3 AS MAVEN-BUILD
#RUN apk --no-cache add openjdk11
#RUN apk --no-cache add maven
#WORKDIR /build/
##MAVEN DEPENDENCIES
#COPY pom.xml /build/
#RUN mvn dependency:go-offline
#COPY src /build/src/
#RUN mvn clean package
#
#FROM alpine:3.11.3
#RUN apk --no-cache add openjdk11
##FETCH MAVEN-BUILD
#COPY --from=MAVEN-BUILD /build/target/my-angular-springboot-0.0.1-SNAPSHOT.jar /application/
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/my-angular-springboot-0.0.1-SNAPSHOT.jar"]

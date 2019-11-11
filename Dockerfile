FROM openjdk:8u131-jre-alpine

RUN mkdir -v /app

ADD  target/api-0.0.1-SNAPSHOT.jar /app
EXPOSE 8585
ENTRYPOINT ["java","-jar","/app/api-0.0.1-SNAPSHOT.jar"]

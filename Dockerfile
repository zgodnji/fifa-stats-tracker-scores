FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./target/scores-1.0.0.jar /app

EXPOSE 8083

CMD ["java", "-jar", "scores-1.0.0.jar"]

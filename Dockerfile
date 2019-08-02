FROM openjdk:8-jre-alpine


ENV ENV=DEV

EXPOSE 80
VOLUME /tmp

COPY build/libs/springbootexample.jar app.jar

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar app.jar --spring.profiles.active=$ENV

FROM eclipse-temurin:17-jdk
VOLUME /tmp
ARG DEPENDENCY=build
RUN echo ${DEPENDENCY}
COPY ${DEPENDENCY}/libs/za-0.0.1-SNAPSHOT.jar /app/lib/za.jar
ENTRYPOINT ["java","-jar","/app/lib/za.jar"]

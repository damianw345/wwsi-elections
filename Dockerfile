FROM openjdk:11.0.4-jdk-slim AS BUILD_IMAGE
COPY gradle ./gradle
COPY build.gradle settings.gradle gradlew ./
# download and cache dependencies in Docker layer for subsequent builds
RUN ./gradlew --info resolveDependencies

COPY . .
RUN ./gradlew --info build

FROM openjdk:11.0.4-jre-slim

EXPOSE 8080 5005
ENV HOME /home
WORKDIR $HOME
COPY docker-run.sh .
COPY --from=BUILD_IMAGE build/libs/elections-0.0.1-SNAPSHOT.jar elections.jar

CMD ["bash", "./docker-run.sh"]

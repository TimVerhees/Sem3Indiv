FROM gradle:7.5.1-jdk17-alpine AS build
COPY . /temp
WORKDIR /temp
RUN gradle build --no-daemon


FROM openjdk:17-alpine
# ARG JAR_FILE=./build/libs/Sem3Individual-1.0-SNAPSHOT.jar
COPY --from=build /temp/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
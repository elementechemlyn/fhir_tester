FROM maven:3.6.2-jdk-11 as buildchain
RUN mkdir -p /usr/src/fhirviewer
WORKDIR /usr/src/fhirviewer
COPY . /usr/src/fhirviewer
RUN mvn -e -B dependency:resolve
RUN mvn clean install -DskipTests

FROM openjdk:8-jdk-alpine
EXPOSE 9090
ARG JAR_FILE=/usr/src/fhirviewer/target/demo-0.0.1-SNAPSHOT.war
COPY --from=buildchain ${JAR_FILE} app.war
ENTRYPOINT ["java","-jar","/app.war"]
FROM maven:3.6.0-jdk-11-slim AS  DEPS

WORKDIR /opt/app
COPY domain/pom.xml domain/pom.xml
COPY infrastructure/pom.xml infrastructure/pom.xml
COPY application/pom.xml application/pom.xml
COPY pom.xml .
RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline


FROM maven:3.6.0-jdk-11-slim AS BUILDER
WORKDIR /opt/app
COPY --from=deps /root/.m2 /root/.m2
COPY --from=deps /opt/app/ /opt/app
COPY domain/src /opt/app/domain/src
COPY infrastructure/src /opt/app/infrastructure/src
COPY application/src /opt/app/application/src

RUN mvn -B -e clean install

FROM openjdk:11-jre-slim
WORKDIR /opt/app
COPY --from=builder /opt/app/application/target/fizzbuzz-spring-boot.jar fizzbuzz.jar
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=dev", "fizzbuzz.jar"]

FROM maven:3.6.0-jdk-11-slim AS  DEPS
ARG profile
WORKDIR /opt/app
COPY domain/pom.xml domain/pom.xml
COPY infrastructure/pom.xml infrastructure/pom.xml
COPY application/pom.xml application/pom.xml
COPY pom.xml .
RUN if [ "x$profile" = "xprod" ] ; then mvn -B -e -C  -P prod org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline; else mvn -B -e -C  -P dev org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline ; fi



FROM maven:3.6.0-jdk-11-slim AS BUILDER
ARG profile
WORKDIR /opt/app
COPY --from=deps /root/.m2 /root/.m2
COPY --from=deps /opt/app/ /opt/app
COPY domain/src /opt/app/domain/src
COPY infrastructure/src /opt/app/infrastructure/src
COPY application/src /opt/app/application/src

RUN if [ "x$profile" = "xprod" ] ; then mvn -P prod -B -e clean install ; else mvn -P dev -B -e clean install ; fi

FROM openjdk:11-jre-slim
ARG profile
ENV spring.profiles.active=$profile
WORKDIR /opt/app
COPY --from=builder /opt/app/application/target/fizzbuzz-spring-boot.jar fizzbuzz.jar
ENTRYPOINT [ "java", "-jar", "fizzbuzz.jar"]

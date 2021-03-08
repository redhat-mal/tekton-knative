#FROM quay.io/rhdevelopers/quarkus-java-builder:graal-1.0.0-rc15 as builder
FROM registry.redhat.io/openjdk/openjdk-11-rhel7
COPY . /project
WORKDIR /project
# uncomment this to set the MAVEN_MIRROR_URL of your choice, to make faster builds
# ARG MAVEN_MIRROR_URL=<your-maven-mirror-url>
# e.g.
#ARG MAVEN_MIRROR_URL=http://192.168.64.1:8081/nexus/content/groups/public

RUN ./mvnw -DskipTests package

#FROM fabric8/java-jboss-openjdk8-jdk:1.5.4
#USER jboss
ENV JAVA_APP_DIR=/deployments

RUN cp /project/target/*.jar /deployments/
COPY ./mvnw /deployments/

EXPOSE["8080"]

ENTRYPOINT [ "/deployments/mvnw", "quarkus:dev" ]

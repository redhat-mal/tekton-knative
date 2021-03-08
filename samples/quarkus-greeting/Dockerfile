FROM image-registry.openshift-image-registry.svc:5000/openshift/java:11
#FROM registry.redhat.io/openjdk/openjdk-11-rhel7
COPY . /project
WORKDIR /project
# uncomment this to set the MAVEN_MIRROR_URL of your choice, to make faster builds
# ARG MAVEN_MIRROR_URL=<your-maven-mirror-url>
# e.g.
#ARG MAVEN_MIRROR_URL=http://192.168.64.1:8081/nexus/content/groups/public
RUN /opt/rh/rh-maven36/root/usr/bin/mvn -DskipTests package

#FROM fabric8/java-jboss-openjdk8-jdk:1.5.4
#USER jboss
ENV JAVA_APP_DIR=/deployments

RUN cp /project/target/*.jar /deployments/
COPY ./mvnw /deployments/

EXPOSE "8080"

ENTRYPOINT [ "/opt/rh/rh-maven36/root/usr/bin/mvn", "quarkus:dev" ]

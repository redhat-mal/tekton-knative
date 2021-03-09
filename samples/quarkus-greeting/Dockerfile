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
#ENV JAVA_APP_JAR=/deployments/helloworld-java-quarkus-1.0-SNAPSHOT-runner.jar

RUN ls -lrtR ./target/quarkus-app
# Configure the JAVA_OPTIONS, you can add -XshowSettings:vm to also display the heap size.
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=1001 /project/target/quarkus-app/lib/ /deployments/lib/
COPY --chown=1001 /project/target/quarkus-app/*.jar /deployments/
COPY --chown=1001 /project/target/quarkus-app/app/ /deployments/app/
COPY --chown=1001 /project/target/quarkus-app/quarkus/ /deployments/quarkus/

WORKDIR /deployments

EXPOSE 8080
USER 1001


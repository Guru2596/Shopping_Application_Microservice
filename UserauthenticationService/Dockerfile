FROM openjdk
WORKDIR usr/lib
EXPOSE 8085
ADD ./target/authenticationService-0.0.1-SNAPSHOT.jar /usr/lib/authenticationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","authenticationService-0.0.1-SNAPSHOT.jar"]
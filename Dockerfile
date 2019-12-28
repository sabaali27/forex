FROM openjdk:8
ADD target/forex-0.0.1-SNAPSHOT.jar forex.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","forex.jar"]

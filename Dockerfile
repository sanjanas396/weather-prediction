FROM openjdk:8
EXPOSE 8080
Add target/weather-prediction.jar weather-prediction.jar
ENTRYPOINT ["java", "-jar","/weather-prediction.jar"]
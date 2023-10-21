# Weather Prediction Service

This service provides weather predictions based on OpenWeatherMap data.

## API Documentation

You can view the API documentation using Swagger. Access the Swagger UI at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) when the application is running.

### Error Codes

- `200`: Success
- `400`: Bad Request
- `401`: Unauthorized
- `404`: Not Found
- `500`: Internal Server Error

## Design and Implementation

This Spring Boot application follows a Service Layer pattern, separating concerns into different layers.

### Design Patterns Used

- Service Layer Pattern: Services are used for specific parts of the application logic.
- Dependency Injection: Spring's Dependency Injection is used for injecting dependencies.

## Configuration

### API Key and URLs

API key and URLs for OpenWeatherMap should be configured in `application.properties`:

### Run code with Docker
`mvn clean install`
`docker build -t weather-prediction.jar .`
`docker run -p 8080:8080 weather-prediction.jar`

package com.weather.prediction.controller;

import com.weather.prediction.model.WeatherAPIResponse;
import com.weather.prediction.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @ApiOperation("Returns a Weather response object which has timeline and day-wise weather prediction " +
            "details. In case API is invoked with invalid city name or exceptions, backend return HTTP 500 response.")
    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<WeatherAPIResponse> getCity(@ApiParam("City's name") @RequestParam String city) {
        System.out.println("city "+city);
        try {
            WeatherAPIResponse response = weatherService.getWeatherAPIResponse(city);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("Exception while fetching the weather API response "+e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new WeatherAPIResponse());
        }
    }

}

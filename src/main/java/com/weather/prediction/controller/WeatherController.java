package com.weather.prediction.controller;

import com.weather.prediction.model.OpenWeatherResponse;
import com.weather.prediction.model.WeatherResponse;
import com.weather.prediction.model.Wind;
import com.weather.prediction.service.OpenWeatherMapAPIService;
import com.weather.prediction.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @ApiOperation("Return a JSON object that gives the weather averages.")
    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public WeatherResponse getCity(@ApiParam("City's name") @RequestParam String city) {
        System.out.println("city "+city);
        return weatherService.getWeatherService(city);
    }

}

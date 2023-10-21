package com.weather.prediction.service;

import com.weather.prediction.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    OpenWeatherMapAPIService openWeatherMapAPIService;
    @Autowired
    TimewiseWeatherService timewiseWeatherService;

    @Autowired
    DaywiseWeatherService daywiseWeatherService;

    public WeatherAPIResponse getWeatherAPIResponse(String city) {
        OpenWeatherAPIResponse resp = openWeatherMapAPIService.invokeOpenWeatherAPIUrl(city, 40);
        return getWeatherResponse(resp);
    }

    public WeatherAPIResponse getWeatherResponse(OpenWeatherAPIResponse resp) {
        List<WeatherList> weatherList = resp.getList();
        WeatherAPIResponse weatherResponse = new WeatherAPIResponse();
        weatherResponse.setTimeWiseWeatherList(timewiseWeatherService.getTimeWiseWeatherList(weatherList));
        weatherResponse.setDaywiseWeatherList(daywiseWeatherService.getDaywiseWeatherList(weatherList));
        weatherResponse.setCity(resp.getCity());
        return weatherResponse;
    }





}

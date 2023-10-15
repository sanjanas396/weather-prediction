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

    public WeatherResponse getWeatherService(String city) {
        OpenWeatherResponse resp = openWeatherMapAPIService.invokeOpenWeatherAPIUrl(city, 10);
        return getWeatherResponse(resp);
    }

    public WeatherResponse getWeatherResponse(OpenWeatherResponse resp) {
        List<WeatherList> weatherList = resp.getList();
        List<TimeWiseWeather> timeWiseWeather = timewiseWeatherService.getTimeWiseWeather(weatherList);

        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setTimeWiseWeatherList(timeWiseWeather);
        return weatherResponse;
    }




}

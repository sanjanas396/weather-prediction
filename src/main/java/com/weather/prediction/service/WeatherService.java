package com.weather.prediction.service;

import com.weather.prediction.Utils.MiscUtils;
import com.weather.prediction.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherService {
    @Autowired
    OpenWeatherMapAPIService openWeatherMapAPIService;
    @Autowired
    TimewiseWeatherService timewiseWeatherService;

    @Autowired
    DaywiseWeatherService daywiseWeatherService;

    public WeatherResponse getWeatherService(String city) {
        OpenWeatherResponse resp = openWeatherMapAPIService.invokeOpenWeatherAPIUrl(city, 40);
        return getWeatherResponse(resp);
    }

    public WeatherResponse getWeatherResponse(OpenWeatherResponse resp) {
        List<WeatherList> weatherList = resp.getList();

        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setTimeWiseWeatherList(timewiseWeatherService.getTimeWiseWeatherList(weatherList));
        weatherResponse.setDaywiseWeatherList(daywiseWeatherService.getDaywiseWeatherList(weatherList));
        weatherResponse.setCity(resp.getCity());
        return weatherResponse;
    }





}

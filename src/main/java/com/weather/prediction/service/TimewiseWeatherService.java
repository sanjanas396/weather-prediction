package com.weather.prediction.service;

import com.weather.prediction.Utils.MiscUtils;
import com.weather.prediction.model.TimeWiseWeather;
import com.weather.prediction.model.WeatherList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Component("timewiseWeatherService")
@Service
public class TimewiseWeatherService {

    @Autowired
    CurrentWeatherService currentWeatherService;
    public List<TimeWiseWeather> getTimeWiseWeatherList(List<WeatherList> weatherList) {
        return weatherList.subList(0,8).stream().map(this::getTimewiseWeather).collect(Collectors.toList());
    }

    public TimeWiseWeather getTimewiseWeather(WeatherList weather) {
        TimeWiseWeather timeWiseWeather = new TimeWiseWeather();
        timeWiseWeather.setCurrentWeather(currentWeatherService.getCurrentWeather(weather));
        timeWiseWeather.setId("time_"+(new Random().nextInt()));
        return timeWiseWeather;
    }
}

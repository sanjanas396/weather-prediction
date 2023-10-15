package com.weather.prediction.service;

import com.weather.prediction.model.TimeWiseWeather;
import com.weather.prediction.model.WeatherList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component("timewiseWeatherService")
@Service
public class TimewiseWeatherService {

    @Autowired
    CurrentWeatherService currentWeatherService;
    public List<TimeWiseWeather> getTimeWiseWeather(List<WeatherList> weatherList) {
        return weatherList.stream().map(weather -> {
            TimeWiseWeather timeWiseWeather = new TimeWiseWeather();
            timeWiseWeather.setCurrentWeather(currentWeatherService.getCurrentWeather(weather));
            timeWiseWeather.setTimestamp(weather.getDt_txt());
            timeWiseWeather.setTemp(weather.getMain().getTemp());
            timeWiseWeather.setIcon(weather.getWeather().get(0).getIcon());
            return timeWiseWeather;
        }).collect(Collectors.toList());
    }
}

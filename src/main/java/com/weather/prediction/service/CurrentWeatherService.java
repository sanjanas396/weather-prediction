package com.weather.prediction.service;

import com.weather.prediction.model.CurrentWeather;
import com.weather.prediction.model.WeatherList;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("currentWeatherService")
@Service
public class CurrentWeatherService {
    public CurrentWeather getCurrentWeather(WeatherList weather) {
        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setTimeStamp(weather.getDt_txt());
        currentWeather.setTemperature(weather.getMain().getTemp());
        currentWeather.setHumidity(weather.getMain().getHumidity());
        currentWeather.setMaxTemp(weather.getMain().getTempMax());
        currentWeather.setMinTemp(weather.getMain().getTempMin());
        currentWeather.setWindSpeed(weather.getWind().getSpeed());
        currentWeather.setClouds(weather.getClouds().getAll());
        currentWeather.setIcon(weather.getWeather().get(0).getIcon());
        currentWeather.setDesc(weather.getWeather().get(0).getDescription());
        System.out.println(currentWeather.toString());
        return currentWeather;
    }
}

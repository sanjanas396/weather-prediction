package com.weather.prediction.service;

import com.weather.prediction.model.CurrentWeather;
import com.weather.prediction.model.WeatherList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Component("currentWeatherService")
@Service
public class CurrentWeatherService {

    @Autowired
    MessageService messageService;

    public CurrentWeather getCurrentWeather(WeatherList weather) {
        CurrentWeather currentWeather = new CurrentWeather();
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        currentWeather.setTimeStamp(weather.getDt_txt());
        currentWeather.setTemperature(Float.parseFloat(decimalFormat.format(weather.getMain().getTemp())));
        currentWeather.setHumidity(weather.getMain().getHumidity());
        currentWeather.setTempMax(Float.parseFloat(decimalFormat.format(weather.getMain().getTempMax())));
        currentWeather.setTempMin(Float.parseFloat(decimalFormat.format(weather.getMain().getTempMin())));
        currentWeather.setWindSpeed(Float.parseFloat(decimalFormat.format(weather.getWind().getSpeed())));
        currentWeather.setClouds(weather.getClouds().getAll());
        currentWeather.setIcon(weather.getWeather().get(0).getIcon());
        currentWeather.setDesc(weather.getWeather().get(0).getDescription());
        currentWeather.setMessage(messageService.getMessage(weather.getWeather().get(0).getMain()));
        currentWeather.setTime(weather.getDt_txt().split(" ")[1]);
        System.out.println(currentWeather.toString());
        return currentWeather;
    }
}

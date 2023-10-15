package com.weather.prediction.model;

import java.util.List;

public class WeatherResponse {

    List<TimeWiseWeather> timeWiseWeatherList;

    public List<TimeWiseWeather> getTimeWiseWeatherList() {
        return timeWiseWeatherList;
    }

    public void setTimeWiseWeatherList(List<TimeWiseWeather> timeWiseWeatherList) {
        this.timeWiseWeatherList = timeWiseWeatherList;
    }
}

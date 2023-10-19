package com.weather.prediction.model;

import org.springframework.context.annotation.Bean;

public class TimeWiseWeather {

    CurrentWeather currentWeather;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

}

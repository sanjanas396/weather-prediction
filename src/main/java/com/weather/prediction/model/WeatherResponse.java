package com.weather.prediction.model;

import java.util.List;

public class WeatherResponse {

    List<TimeWiseWeather> timeWiseWeatherList;
    List<TimeWiseWeather> daywiseWeatherList;
    City city;

    public List<TimeWiseWeather> getTimeWiseWeatherList() {
        return timeWiseWeatherList;
    }

    public void setTimeWiseWeatherList(List<TimeWiseWeather> timeWiseWeatherList) {
        this.timeWiseWeatherList = timeWiseWeatherList;
    }

    public List<TimeWiseWeather> getDaywiseWeatherList() {
        return daywiseWeatherList;
    }

    public void setDaywiseWeatherList(List<TimeWiseWeather> daywiseWeatherList) {
        this.daywiseWeatherList = daywiseWeatherList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

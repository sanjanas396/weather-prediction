package com.weather.prediction.service;

import com.weather.prediction.Utils.MiscUtils;
import com.weather.prediction.model.TimeWiseWeather;
import com.weather.prediction.model.WeatherList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DaywiseWeatherService {

    @Autowired
    TimewiseWeatherService timewiseWeatherService;

    public List<TimeWiseWeather> getDaywiseWeatherList(List<WeatherList> weatherLists) {
        String date = MiscUtils.getCurrentDate();
        weatherLists.removeAll(
                weatherLists.stream()
                        .filter(cur -> cur.getDt_txt().contains(date))
                        .collect(Collectors.toList()));
        return weatherLists.stream()
                .map(cur -> timewiseWeatherService.getTimewiseWeather(cur))
                .collect(Collectors.toList());
    }
}

package com.weather.prediction.service;

import com.weather.prediction.Utils.MiscUtils;
import com.weather.prediction.model.TimeWiseWeather;
import com.weather.prediction.model.WeatherList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DaywiseWeatherService {

    @Autowired
    TimewiseWeatherService timewiseWeatherService;

    public Map<String,List<TimeWiseWeather>> getDayWiseWeather(List<WeatherList> weatherLists) {

        Map<String, List<TimeWiseWeather>> daywiseMap = new HashMap<>();
        daywiseMap.put("today", weatherLists.subList(0,8).stream()
                .map(weather -> timewiseWeatherService.getTimewiseWeather(weather))
                .collect(Collectors.toList()));
        String date = MiscUtils.getCurrentDate();
        System.out.println("currentdate "+date);
        weatherLists.removeAll(
                weatherLists.stream()
                        .filter(cur -> cur.getDt_txt().contains(date))
                        .collect(Collectors.toList()));

        List<TimeWiseWeather> dayWiseWeatherList = new ArrayList<>();
        for(WeatherList weather : weatherLists) {
            dayWiseWeatherList.add(timewiseWeatherService.getTimewiseWeather(weather));
            if(dayWiseWeatherList.size() % 8 == 0) {
                System.out.println("currentdate "+MiscUtils.getDateFromTs(weather.getDt_txt()));
                daywiseMap.put(MiscUtils.getDateFromTs(weather.getDt_txt()), dayWiseWeatherList);
                dayWiseWeatherList = new ArrayList<>();
            }
        }
        return daywiseMap;
    }

    public List<TimeWiseWeather> getDaywiseWeatherList(List<WeatherList> weatherLists) {
        System.out.println("size "+weatherLists.size());
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

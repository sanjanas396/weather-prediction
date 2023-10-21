package com.weather.prediction.service;

import com.weather.prediction.model.OpenWeatherAPIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapAPIService {
//    private final String OPEN_WEATHER_MAP_URL = "https://api.openweathermap.org/data/2.5/forecast";
//    private final String API_KEY = "d2929e9483efc82c82c32ee7e02d563e";
    @Value("${api.openweathermap.key}")
    private String apiKey;

    @Value("${api.openweathermap.url}")
    private String openWeatherUrl;


    public OpenWeatherAPIResponse invokeOpenWeatherAPIUrl(String city, int cnt) {
        String apiUrl = openWeatherUrl + "?units=metric&q=" + city + "&appid=" + apiKey+"&cnt="+cnt;
        System.out.println(apiUrl);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, OpenWeatherAPIResponse.class);
    }
}

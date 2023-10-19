package com.weather.prediction.model;

public class CurrentWeather {

    public CurrentWeather() {}

    String timeStamp;
    float temperature;
    int humidity;
    float tempMin;
    float tempMax;
    float windSpeed;
    String icon;
    String desc;
    String message;
    int clouds;
    String time;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public float getTempMin() {
        return tempMin;
    }
    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }
    public float getTempMax() {
        return tempMax;
    }
    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "timeStamp='" + timeStamp + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", windSpeed=" + windSpeed +
                ", icon='" + icon + '\'' +
                ", desc='" + desc + '\'' +
                ", message='" + message + '\'' +
                ", clouds=" + clouds +
                ", time='" + time + '\'' +
                '}';
    }
}

package com.weather.prediction.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    private float temp;
    @JsonProperty("temp_min")
    private float tempMin;
    @JsonProperty("temp_max")
    private float tempMax;

    private float pressure;

    private int humidity;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
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

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", temp_min=" + tempMin +
                ", temp_max=" + tempMax +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}

package com.weather.prediction.model;

public class Wind {

    public Wind(){}

    public Wind(float speed, String deg, String gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    float speed;
    String deg;
    String gust;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getGust() {
        return gust;
    }

    public void setGust(String gust) {
        this.gust = gust;
    }
}

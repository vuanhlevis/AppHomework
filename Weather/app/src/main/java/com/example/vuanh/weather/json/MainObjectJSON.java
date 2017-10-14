package com.example.vuanh.weather.json;

import java.util.List;

/**
 * Created by vuanh on 10/14/2017.
 */

public class MainObjectJSON {
    private List<WeatherJSON> weather;
    private MainJSON main;
    private long dt;

    public MainObjectJSON(List<WeatherJSON> weather, MainJSON main, long dt) {
        this.weather = weather;
        this.main = main;
        this.dt = dt;
    }

    public List<WeatherJSON> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherJSON> weather) {
        this.weather = weather;
    }

    public MainJSON getMain() {
        return main;
    }

    public void setMain(MainJSON main) {
        this.main = main;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }
}

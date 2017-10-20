package com.example.vuanh.weather.json;

/**
 * Created by vuanh on 10/14/2017.
 */

public class WeatherJSON {
    private String dt;
    private MainJSON main;

    public WeatherJSON(String dt, MainJSON main) {
        this.dt = dt;
        this.main = main;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public MainJSON getMain() {
        return main;
    }

    public void setMain(MainJSON main) {
        this.main = main;
    }
}

package com.example.vuanh.weather.json;

import java.util.List;

/**
 * Created by vuanh on 10/14/2017.
 */

public class MainObjectJSON {
    private List<WeatherJSON> list;

    public MainObjectJSON(List<WeatherJSON> list) {
        this.list = list;
    }

    public List<WeatherJSON> getList() {
        return list;
    }
}

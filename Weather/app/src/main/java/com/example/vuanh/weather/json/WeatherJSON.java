package com.example.vuanh.weather.json;

/**
 * Created by vuanh on 10/14/2017.
 */

public class WeatherJSON {
    private String id;
    private String main;
    private String description;

    public WeatherJSON(String id, String main, String description) {
        this.id = id;
        this.main = main;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

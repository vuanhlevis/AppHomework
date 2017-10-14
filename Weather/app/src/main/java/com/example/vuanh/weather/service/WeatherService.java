package com.example.vuanh.weather.service;

import com.example.vuanh.weather.json.MainObjectJSON;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vuanh on 10/14/2017.
 */

public interface WeatherService {
    @GET("data/2.5/weather")
    Call<MainObjectJSON> getDataWeather(@Query("q") String city, @Query("APPID") String appID);
}

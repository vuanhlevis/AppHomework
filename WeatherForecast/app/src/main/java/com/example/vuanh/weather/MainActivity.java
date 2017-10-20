package com.example.vuanh.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vuanh.weather.adapters.WeatherAdapter;
import com.example.vuanh.weather.json.MainObjectJSON;
import com.example.vuanh.weather.json.WeatherJSON;
import com.example.vuanh.weather.service.WeatherService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String APPID = "88d9a58179deef612b0cb6cc0d4e1964";

    private EditText et_city;
    private TextView tv_city;
    private TextView tv_weather;
    private TextView tv_temp;
    private TextView tv_humidity;
    private Button bt_search;
    private RecyclerView rv_item;

    private List<WeatherJSON> list = new ArrayList<>();
    private WeatherAdapter weatherAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inPut();

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nameCity = et_city.getText().toString();

                WeatherService weatherService = RetrofitFactory.getInstance().create(WeatherService.class);

                if (nameCity == null) {
                    Toast.makeText(MainActivity.this, "Điền tên vào thằng ngu", Toast.LENGTH_SHORT).show();
                } else {
                    weatherService.getDataWeather(nameCity, APPID, 7)
                            .enqueue(new Callback<MainObjectJSON>() {
                                @Override
                                public void onResponse(Call<MainObjectJSON> call, Response<MainObjectJSON> response) {
                                    if (response.body() == null) {
                                        Toast.makeText(MainActivity.this, "Nhập tên cũng ngu, nhập lại đi tml", Toast.LENGTH_SHORT).show();
                                    } else {
                                        list.clear();

                                        List<WeatherJSON> weatherJSONs = response.body().getList();
                                        Log.d("xxxxx", "onResponse: " + response.body().toString());

                                        tv_temp.setText("Temp: " + response.body().getList().get(0).getMain().getTemp());
                                        tv_city.setText("City: " + nameCity.toString());
                                        tv_humidity.setText("Humid: " + response.body().getList().get(0).getMain().getHumidity() + "%");
                                        tv_weather.setText("Weather: " + response.body().getList().get(0).getMain().getTemp() + "°C");

                                        for (WeatherJSON weatherJSON: weatherJSONs) {
                                            if (weatherJSON!= null) {
                                                list.add(weatherJSON);
                                            }
                                        }

                                        weatherAdapter = new WeatherAdapter(list);
                                        rv_item.setAdapter(weatherAdapter);


                                    }
                                }

                                @Override
                                public void onFailure(Call<MainObjectJSON> call, Throwable t) {

                                }
                            });
                }
            }
        });
    }

    private void inPut() {
        et_city = (EditText) findViewById(R.id.et_city);
        tv_city = (TextView) findViewById(R.id.tv_city);
        tv_weather = (TextView) findViewById(R.id.tv_main);
        tv_temp = (TextView) findViewById(R.id.tv_temp);
        tv_humidity = (TextView) findViewById(R.id.tv_humidity);
        bt_search = (Button) findViewById(R.id.bt_search);


        rv_item = (RecyclerView) findViewById(R.id.rv_weather_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        weatherAdapter = new WeatherAdapter(list);
        rv_item.setAdapter(weatherAdapter);
        rv_item.setLayoutManager(linearLayoutManager);

    }
}

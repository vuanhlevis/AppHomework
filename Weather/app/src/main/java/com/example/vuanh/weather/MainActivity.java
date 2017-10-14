package com.example.vuanh.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vuanh.weather.json.MainObjectJSON;
import com.example.vuanh.weather.service.WeatherService;

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
                    weatherService.getDataWeather(nameCity, APPID)
                            .enqueue(new Callback<MainObjectJSON>() {
                                @Override
                                public void onResponse(Call<MainObjectJSON> call, Response<MainObjectJSON> response) {
                                    if (response.body() == null) {
                                        Toast.makeText(MainActivity.this, "Nhập tên cũng ngu, nhập lại đi tml", Toast.LENGTH_SHORT).show();
                                    } else {
                                        tv_city.setText("City: " + nameCity.toString());
                                        tv_temp.setText("Temp: " + response.body().getMain().getTemp());
                                        tv_weather.setText("Weather: " + response.body().getWeather().get(0).getMain());
                                        tv_humidity.setText("Humidity: " + response.body().getMain().getHumidity() + "%");
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
    }
}

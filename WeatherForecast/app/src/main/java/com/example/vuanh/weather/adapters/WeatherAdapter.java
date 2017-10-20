package com.example.vuanh.weather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vuanh.weather.R;
import com.example.vuanh.weather.json.MainObjectJSON;
import com.example.vuanh.weather.json.WeatherJSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by vuanh on 10/20/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private Context context;
    private List<WeatherJSON> list;

    public WeatherAdapter(List<WeatherJSON> list) {
        this.list = list;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.weather_day_item, parent, false);

        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {

        TextView tv_time_item;
        TextView tv_humid_item;
        TextView tv_temp_item;

        public WeatherViewHolder(View itemView) {
            super(itemView);

            tv_time_item = itemView.findViewById(R.id.tv_time_item);
            tv_humid_item = itemView.findViewById(R.id.tv_humid_item);
            tv_temp_item = itemView.findViewById(R.id.tv_temp_item);
        }

        public void setData(WeatherJSON list) {
            Date date;
            String dateformat = "";

            SimpleDateFormat formatInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat formatOutput = new SimpleDateFormat("dd/MM");

            try {
                date = formatInput.parse(list.getDt());
                dateformat = formatOutput.format(date.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Integer.parseInt(list.getDt()));
            Log.d("xxxx", "setData: " + list.getDt());

            tv_time_item.setText(formatInput.format(calendar.getTime()));
            tv_humid_item.setText(list.getMain().getHumidity() + " %");

            tv_temp_item.setText(list.getMain().getTemp() + "°F");
        }
    }
}

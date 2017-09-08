package com.example.levua.storyhw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by levua on 9/7/2017.
 */

public class StoryAdapter extends ArrayAdapter<Story_model> {

    private Context context;
    private int resource;
    private List<Story_model> storyModelList;

    public StoryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Story_model> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        storyModelList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView = layoutInflater.inflate(resource, parent, false);

        Story_model storyModel = storyModelList.get(position);

        View bookmark = convertView.findViewById(R.id.v_bookmark);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_story);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tv_author);

        tvAuthor.setText(storyModel.getAuthor());
        tvTitle.setText(storyModel.getTitle());

        String imageString = storyModel.getImage();

        imageString = imageString.substring(imageString.indexOf(',') + 1);

        byte[] imageBytes = Base64.decode(imageString, Base64.DEFAULT);

        Bitmap decodeImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

        imageView.setImageBitmap(decodeImage);
        Log.d(TAG, "getImageString " + imageString);

        return convertView;
    }
}

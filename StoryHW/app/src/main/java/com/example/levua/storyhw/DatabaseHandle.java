package com.example.levua.storyhw;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levua on 9/7/2017.
 */

public class DatabaseHandle {
    private static final String TAG = "ListStory";
    private MyDatabase myDatabase;

    public DatabaseHandle(Context context) {
        myDatabase = new MyDatabase(context);
    }

    private static DatabaseHandle databaseHandle;

    public static DatabaseHandle getInstance(Context context) {
        if (databaseHandle == null) {
            databaseHandle = new DatabaseHandle(context);
        }

        return databaseHandle;
    }

    private SQLiteDatabase sqLiteDatabase;

    public List<Story_model> getListStory() {
        List<Story_model> storyModelList = new ArrayList<>();

        sqLiteDatabase = myDatabase.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_short_story", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            boolean bookmark = cursor.getInt(6) != 0;

            Story_model storyModel = new Story_model(id, image, title,
                    description, content, author, bookmark);

            storyModelList.add(storyModel);

            cursor.moveToNext();
        }

        Log.d(TAG, "getListStory: " + storyModelList.toString());

        return storyModelList;
    }

}

package com.example.levua.storyhw;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv_Story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_Story = (ListView) findViewById(R.id.lv_story);

        StoryAdapter storyAdapter = new StoryAdapter(this,R.layout.item_list_story,
                DatabaseHandle.getInstance(this).getListStory());

        lv_Story.setAdapter(storyAdapter);

    }
}

package com.example.swapibrowser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.swapibrowser.R;
import com.example.swapibrowser.utils.PageSaver;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PageSaver saver = new PageSaver();

        ArrayList<String> test = saver.readFavorite(this);
        Log.d("empty", "empty");
    }

    public void goToRandomPageActivity(View view) {
        Intent intent = new Intent(MainActivity.this, RandomPage.class);
        startActivity(intent);
    }

    public void goToRecentlyUpdatedActivity(View view){
        Intent intent = new Intent(MainActivity.this, RecentlyUpdated.class);
        startActivity(intent);
    }

    public void goToSearchActivity(View view){
        Intent intent = new Intent(MainActivity.this, Search.class);
        startActivity(intent);
    }

    public void goToRecentlyViewedActivity(View view){
        Intent intent = new Intent(MainActivity.this, LastVisited.class);
        startActivity(intent);
    }

    public void goToFavorite(View view){
        Intent intent = new Intent(MainActivity.this, FavoritePages.class);
        startActivity(intent);
    }
}
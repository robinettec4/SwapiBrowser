package com.example.swapibrowser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.swapibrowser.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
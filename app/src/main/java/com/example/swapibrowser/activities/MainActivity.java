package com.example.swapibrowser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.swapibrowser.R;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.models.person.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final People people = new People();
        people.setPeople(new ArrayList<Person>());

        Intent intent = new Intent(MainActivity.this, RecentlyUpdated.class);
        startActivity(intent);
    }

    public void doSomethingExample(People o){
        System.out.println(o.getPeople());
    }
}
package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.PersonAdapter;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.generators.PersonGenerator;
import com.example.swapibrowser.utils.InternetConnection;

import java.util.ArrayList;

public class RecentlyUpdated extends AppCompatActivity {

    RecyclerView recentlyUpdatedRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recently_updated);
        recentlyUpdatedRecycler = findViewById(R.id.recently_updated_recycler);
        loadPersonData();
    }

    public void loadPersonData(){
        if (InternetConnection.checkConnection(getApplicationContext())) {
            final ArrayList<Person> persons = new ArrayList<>();

            final PersonGenerator personGenerator = new PersonGenerator();
            final ApiResponseListener<Person> listener = new ApiResponseListener<Person>() {

                @Override
                public void onResponseReceived(Person response) {
                    persons.add(response);
                    Log.d("ResponseOutput", persons.get(0).getName());
                    recentlyUpdatedRecycler.setAdapter(new PersonAdapter(persons, RecentlyUpdated.this));
                    recentlyUpdatedRecycler.setLayoutManager(new LinearLayoutManager(RecentlyUpdated.this));
                }

                @Override
                public void onError(Throwable error) {
                    Log.d("ResponseOutput", error.getMessage());
                    System.out.println(error.getMessage());
                }
            };
            personGenerator.getById("1", listener);
        }
    }
}
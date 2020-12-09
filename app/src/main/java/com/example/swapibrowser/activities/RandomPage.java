package com.example.swapibrowser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.PersonAdapter;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.PersonGenerator;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.searchers.PeopleSearcher;

import java.util.ArrayList;
import java.util.Random;

public class RandomPage extends AppCompatActivity {
    RecyclerView randomRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_page);
        randomRecycler = findViewById(R.id.recently_updated_recycler);
        int field = decideField();

        decideEntry(1);
    }

    public int decideField(){
        Random ran = new Random();
        int field = ran.nextInt(6);
        return field;
    }

    public void decideEntry(int field){
        switch (field) {
            case 0:
                loadFilmsData();
                break;
            case 1:
                loadPeopleData();
                break;
            case 2:
                loadPlanetsData();
                break;
            case 3:
                loadSpeciesData();
                break;
            case 4:
                loadStarshipsData();
                break;
            case 5:
                loadVehiclesData();
                break;
            default:
                break;
        }
    }

    private void loadVehiclesData() {

    }

    private void loadStarshipsData() {

    }

    private void loadSpeciesData() {

    }

    private void loadPlanetsData() {

    }

    private void loadPeopleData() {
        final PeopleSearcher peopleSearcher = new PeopleSearcher();
        final PersonGenerator personGenerator = new PersonGenerator();
        final ApiResponseListener<People> bigListener = new ApiResponseListener<People>() {
            @Override
            public void onResponseReceived(People response) {
                Log.d("progress", "People onResponseReceived()");
                int entries = response.getCount();
                Random random = new Random();
                int entry = random.nextInt(entries);

                final ArrayList<Person> persons = new ArrayList<>();

                final ApiResponseListener<Person> listener = new ApiResponseListener<Person>() {

                    @Override
                    public void onResponseReceived(Person response) {
                        Log.d("progress", "Person OnResponseReceived");
                        persons.add(response);
                        randomRecycler.setAdapter(new PersonAdapter(persons, RandomPage.this));
                        randomRecycler.setLayoutManager(new LinearLayoutManager(RandomPage.this));
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.out.println(error.getMessage());
                    }
                };
                Log.d("progress", "call personGenerator");
                personGenerator.getById(String.valueOf(entry), listener);
            }
            @Override
            public void onError(Throwable error) { System.out.println(error.getMessage()); }
        };
        Log.d("progress", "call peopleGenerator");
        peopleSearcher.getAll(bigListener);
    }

    private void loadFilmsData() {

    }

    public void reload(View view){
        Intent intent = new Intent(this, RandomPage.class);
        finish();
        startActivity(intent);
    }
}

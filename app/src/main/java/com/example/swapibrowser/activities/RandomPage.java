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
import com.example.swapibrowser.adapters.StarshipAdapter;
import com.example.swapibrowser.adapters.VehicleAdapter;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.PersonGenerator;
import com.example.swapibrowser.generators.StarshipGenerator;
import com.example.swapibrowser.generators.VehicleGenerator;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.models.starship.Starship;
import com.example.swapibrowser.models.starship.Starships;
import com.example.swapibrowser.models.vehicle.Vehicle;
import com.example.swapibrowser.models.vehicle.Vehicles;
import com.example.swapibrowser.searchers.PeopleSearcher;
import com.example.swapibrowser.searchers.StarshipsSearcher;
import com.example.swapibrowser.searchers.VehiclesSearcher;

import java.lang.reflect.Array;
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

        decideEntry(4);
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
        final VehiclesSearcher vehicleSearch = new VehiclesSearcher();
        final VehicleGenerator vehicleGenerator = new VehicleGenerator();
        final ArrayList<Vehicle> vehicles = new ArrayList<>();
        final ApiResponseListener<Vehicles> bigListener = new ApiResponseListener<Vehicles>() {
            @Override
            public void onResponseReceived(Vehicles response) {
                int entries = response.getCount();
                Random random = new Random();
                int entry = random.nextInt(entries);
                final ApiResponseListener<Vehicle> listener = new ApiResponseListener<Vehicle>() {
                    @Override
                    public void onResponseReceived(Vehicle response) {
                        if (response!=null) {
                            vehicles.add(response);
                            randomRecycler.setAdapter(new VehicleAdapter(vehicles, RandomPage.this));
                            randomRecycler.setLayoutManager(new LinearLayoutManager(RandomPage.this));
                        }
                        else{
                            loadVehiclesData(); //not a great implementation if there was a higher chance of failure, but it'll work for now
                        }
                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                };
                vehicleGenerator.getById(String.valueOf(entry), listener);
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        vehicleSearch.getAll(bigListener);
    }

    private void loadStarshipsData() {
        final StarshipsSearcher shipSearch = new StarshipsSearcher();
        final StarshipGenerator shipGenerator = new StarshipGenerator();
        final ArrayList<Starship> starships = new ArrayList<>();
        final ApiResponseListener<Starships> bigListener = new ApiResponseListener<Starships>() {
            @Override
            public void onResponseReceived(Starships response) {
                int entries = response.getCount();
                Random random = new Random();
                int entry = random.nextInt(entries);
                final ApiResponseListener<Starship> listener = new ApiResponseListener<Starship>() {
                    @Override
                    public void onResponseReceived(Starship response) {
                        if (response!=null) {
                            starships.add(response);
                            randomRecycler.setAdapter(new StarshipAdapter(starships, RandomPage.this));
                            randomRecycler.setLayoutManager(new LinearLayoutManager(RandomPage.this));
                        }
                        else{
                            loadStarshipsData(); //not a great implementation if there was a higher chance of failure, but it'll work for now
                        }
                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                };
                shipGenerator.getById(String.valueOf(entry), listener);
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        shipSearch.getAll(bigListener);
    }

    private void loadSpeciesData() {

    }

    private void loadPlanetsData() {

    }

    private void loadPeopleData() {
        final PeopleSearcher peopleSearcher = new PeopleSearcher();
        final PersonGenerator personGenerator = new PersonGenerator();
        final ArrayList<Person> persons = new ArrayList<>();
        final ApiResponseListener<People> bigListener = new ApiResponseListener<People>() {
            @Override
            public void onResponseReceived(People response) {
                Log.d("progress", "People onResponseReceived()");
                int entries = response.getCount();
                Random random = new Random();
                int entry = random.nextInt(entries);

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

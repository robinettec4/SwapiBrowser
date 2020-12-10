package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.FilmAdapter;
import com.example.swapibrowser.adapters.PersonAdapter;
import com.example.swapibrowser.adapters.PlanetAdapter;
import com.example.swapibrowser.adapters.SpeciesResultAdapter;
import com.example.swapibrowser.adapters.StarshipAdapter;
import com.example.swapibrowser.adapters.VehicleAdapter;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.models.film.Film;
import com.example.swapibrowser.models.film.Films;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.models.planet.Planet;
import com.example.swapibrowser.models.planet.Planets;
import com.example.swapibrowser.models.species.Species;
import com.example.swapibrowser.models.species.SpeciesResult;
import com.example.swapibrowser.models.starship.Starship;
import com.example.swapibrowser.models.starship.Starships;
import com.example.swapibrowser.models.vehicle.Vehicle;
import com.example.swapibrowser.models.vehicle.Vehicles;
import com.example.swapibrowser.searchers.FilmsSearcher;
import com.example.swapibrowser.searchers.PeopleSearcher;
import com.example.swapibrowser.searchers.PlanetsSearcher;
import com.example.swapibrowser.searchers.SpeciesSearcher;
import com.example.swapibrowser.searchers.StarshipsSearcher;
import com.example.swapibrowser.searchers.VehiclesSearcher;
import com.example.swapibrowser.utils.PageSaver;


import java.util.ArrayList;


public class Search extends AppCompatActivity {

    RecyclerView searchRecycler;
    EditText inputText;
    private String field;
    private String input;
    PageSaver saver = new PageSaver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchRecycler = findViewById(R.id.search_recycler);
        inputText = findViewById(R.id.input);

        final Spinner searchSpinner = findViewById(R.id.search_spinner);
        searchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                field = searchSpinner.getSelectedItem().toString().toLowerCase();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void search(View view){
        input = inputText.getText().toString().toLowerCase();
        switch (field){
            case "person":
                searchPerson();
                break;
            case "film":
                searchFilm();
                break;
            case "starship":
                searchStarship();
                break;
            case "vehicle":
                searchVehicle();
                break;
            case "species":
                searchSpecies();
                break;
            case "planet":
                searchPlanet();
                break;
            default:
                Log.d("progress", "Default option of switch");
                break;
        }
    }

    private void searchPlanet() {
        final PlanetsSearcher planetsSearcher = new PlanetsSearcher();
        final ArrayList<Planet> planets = new ArrayList<>();
        final ApiResponseListener<Planets> listener = new ApiResponseListener<Planets>() {
            @Override
            public void onResponseReceived(Planets response) {
                if (response != null){
                    planets.add(response.getPlanets().get(0));
                    save(planets.get(0).getUrl());
                    searchRecycler.setAdapter(new PlanetAdapter(planets, Search.this));
                    searchRecycler.setLayoutManager(new LinearLayoutManager(Search.this));
                }
                else{
                    Log.d("response", "no response");
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        planetsSearcher.getBySearch(input, listener);
    }

    private void searchSpecies() {
        final SpeciesSearcher speciesSearcher = new SpeciesSearcher();
        final ArrayList<SpeciesResult> species = new ArrayList<>();
        final ApiResponseListener<Species> listener = new ApiResponseListener<Species>() {
            @Override
            public void onResponseReceived(Species response) {
                if (response != null){
                    species.add(response.getSpeciesResults().get(0));
                    save(species.get(0).getUrl());
                    searchRecycler.setAdapter(new SpeciesResultAdapter(species, Search.this));
                    searchRecycler.setLayoutManager(new LinearLayoutManager(Search.this));
                }
                else{
                    Log.d("response", "no response");
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        speciesSearcher.getBySearch(input, listener);
    }

    private void searchVehicle() {
        final VehiclesSearcher vehiclesSearcher = new VehiclesSearcher();
        final ArrayList<Vehicle> vehicles = new ArrayList<>();
        final ApiResponseListener<Vehicles> listener = new ApiResponseListener<Vehicles>() {
            @Override
            public void onResponseReceived(Vehicles response) {
                if (response != null){
                    vehicles.add(response.getVehicles().get(0));
                    save(vehicles.get(0).getUrl());
                    searchRecycler.setAdapter(new VehicleAdapter(vehicles, Search.this));
                    searchRecycler.setLayoutManager(new LinearLayoutManager(Search.this));
                }
                else{
                    Log.d("response", "no response");
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        vehiclesSearcher.getBySearch(input, listener);
    }

    private void searchStarship() {
        final StarshipsSearcher starshipsSearcher = new StarshipsSearcher();
        final ArrayList<Starship> ships = new ArrayList<>();
        final ApiResponseListener<Starships> listener = new ApiResponseListener<Starships>() {
            @Override
            public void onResponseReceived(Starships response) {
                if (response != null){
                    ships.add(response.getStarships().get(0));
                    save(ships.get(0).getUrl());
                    searchRecycler.setAdapter(new StarshipAdapter(ships, Search.this));
                    searchRecycler.setLayoutManager(new LinearLayoutManager(Search.this));
                }
                else{
                    Log.d("response", "no response");
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        starshipsSearcher.getBySearch(input, listener);
    }

    private void searchFilm() {
        final FilmsSearcher filmsSearcher = new FilmsSearcher();
        final ArrayList<Film> films = new ArrayList<>();
        final ApiResponseListener<Films> listener = new ApiResponseListener<Films>() {
            @Override
            public void onResponseReceived(Films response) {
                if (response != null) {
                    films.add(response.getFilms().get(0));
                    save(films.get(0).getUrl());
                    searchRecycler.setAdapter(new FilmAdapter(films, Search.this));
                    searchRecycler.setLayoutManager(new LinearLayoutManager(Search.this));
                }
                else{
                    Log.d("response", "no response");
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        filmsSearcher.getBySearch(input, listener);
    }

    private void searchPerson() {
        final PeopleSearcher peopleSearcher = new PeopleSearcher();
        final ArrayList<Person> persons = new ArrayList<>();
        final ApiResponseListener<People> listener = new ApiResponseListener<People>() {
            @Override
            public void onResponseReceived(People response) {
                if (response != null) {
                    persons.add(response.getPeople().get(0));
                    save(persons.get(0).getUrl());
                    searchRecycler.setAdapter(new PersonAdapter(persons, Search.this));
                    searchRecycler.setLayoutManager(new LinearLayoutManager(Search.this));
                }
                else{
                    Log.d("response", "no response");
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        peopleSearcher.getBySearch(input, listener);
    }

    public void save(String url){
        saver.save(this, url);
    }
}

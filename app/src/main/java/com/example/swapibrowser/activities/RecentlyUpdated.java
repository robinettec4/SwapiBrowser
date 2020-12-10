package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.FilmAdapter;
import com.example.swapibrowser.adapters.PersonAdapter;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.GeneratorFactory;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.generators.IGeneratorFactory;
import com.example.swapibrowser.models.film.Film;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.generators.PersonGenerator;

import java.io.Serializable;
import java.util.ArrayList;

public class RecentlyUpdated extends AppCompatActivity {

    RecyclerView recentlyUpdatedRecycler;
    IGeneratorFactory generatorFactory = new GeneratorFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recently_updated);
        recentlyUpdatedRecycler = findViewById(R.id.recently_updated_recycler);
        final Spinner recentlyUpdatedSpinner = findViewById(R.id.recently_updated_spinner);

        recentlyUpdatedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getMostRecentItem(recentlyUpdatedSpinner.getSelectedItem().toString().toLowerCase());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void loadFilmData(String itemType){
        final ArrayList<Film> items = new ArrayList<>();
        IGenerator filmGenerator = generatorFactory.CreateGenerator(itemType);
        final ApiResponseListener<Film> listener = new ApiResponseListener<Film>() {

            @Override
            public void onResponseReceived(Film response) {
                items.add(response);
                recentlyUpdatedRecycler.setAdapter(new FilmAdapter(items, RecentlyUpdated.this));
                recentlyUpdatedRecycler.setLayoutManager(new LinearLayoutManager(RecentlyUpdated.this));
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        filmGenerator.getByFullUrl("http://swapi.dev/api/films/1/", listener);
    }

    public void loadPersonData(String itemUrl){
        final ArrayList<Person> items = new ArrayList<>();
        IGenerator personGenerator = generatorFactory.CreateGenerator("person");
        final ApiResponseListener<Person> listener = new ApiResponseListener<Person>() {

            @Override
            public void onResponseReceived(Person response) {
                items.add(response);
                recentlyUpdatedRecycler.setAdapter(new PersonAdapter(items, RecentlyUpdated.this));
                recentlyUpdatedRecycler.setLayoutManager(new LinearLayoutManager(RecentlyUpdated.this));
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        personGenerator.getByFullUrl("http://swapi.dev/api/people/1/", listener);
    }

    public void getMostRecentItem(String itemType){
        if(itemType.equals("person")){
            loadPersonData(itemType);
        } else if (itemType.equals("film")){
            loadFilmData(itemType);
        }
    }

//    public void getMostRecentItem(final String itemType){
//        IGenerator generator = generatorFactory.CreateGenerator(itemType);
//
//        ApiResponseListener<Serializable> listener = new ApiResponseListener<Serializable>() {
//            @Override
//            public void onResponseReceived(Serializable response) {
//                loadPersonData(response);
//            }
//
//            @Override
//            public void onError(Throwable error) {
//                Log.e("ResponseError", error.getMessage());
//            }
//        };
//        generator.getByFullUrl("", listener);
//    }
}
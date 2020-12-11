package com.example.swapibrowser.activities.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.min.MinPersonAdapter;
import com.example.swapibrowser.adapters.min.MinPlanetAdapter;
import com.example.swapibrowser.adapters.min.MinSpeciesResultAdapter;
import com.example.swapibrowser.adapters.min.MinStarshipAdapter;
import com.example.swapibrowser.adapters.min.MinVehicleAdapter;
import com.example.swapibrowser.models.film.Film;

public class ViewFilm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_field_layout);


         TextView filmTitle = findViewById(R.id.film_title);
         TextView filmEpisodeId = findViewById(R.id.film_episode_id);
         TextView filmOpeningCrawl = findViewById(R.id.film_opening_crawl);
         TextView filmDirector = findViewById(R.id.film_director);
         TextView filmProducer = findViewById(R.id.film_producer);
         TextView filmReleaseDate = findViewById(R.id.film_release_date);
         TextView filmEdited = findViewById(R.id.film_edited);
         TextView filmCreated = findViewById(R.id.film_created);

         RecyclerView  filmCharacters = findViewById(R.id.film_characters_recycler);
         RecyclerView filmPlanets = findViewById(R.id.film_planets_recycler);
         RecyclerView filmStarships = findViewById(R.id.film_starships_recycler);
         RecyclerView filmVehicles = findViewById(R.id.film_vehicles_recycler);
         RecyclerView filmSpecies = findViewById(R.id.film_species_recycler);

        Intent intent = getIntent();
        Film film = (Film) intent.getSerializableExtra("films");

        MinPersonAdapter minPersonAdapter = new MinPersonAdapter(film.getCharacters(), ViewFilm.this);
        MinSpeciesResultAdapter minSpeciesResultAdapter = new MinSpeciesResultAdapter(film.getSpecies(), ViewFilm.this);
        MinVehicleAdapter minVehicleAdapter = new MinVehicleAdapter(film.getVehicles(), ViewFilm.this);
        MinStarshipAdapter minStarshipAdapter = new MinStarshipAdapter(film.getStarships(), ViewFilm.this);
        MinPlanetAdapter minPlanetAdapter = new MinPlanetAdapter(film.getPlanets(), ViewFilm.this);

        filmTitle.setText(getString(R.string.film_title, film.getTitle()));
        filmEpisodeId.setText(getString(R.string.film_episode_id, film.getEpisodeId()));
        filmOpeningCrawl.setText(getString(R.string.film_opening_crawl, film.getOpeningCrawl()));
        filmDirector.setText(getString(R.string.film_director, film.getDirector()));
        filmProducer.setText(getString(R.string.film_producer, film.getProducer()));
        filmReleaseDate.setText(getString(R.string.film_release_date, film.getReleaseDate()));
        filmEdited.setText(getString(R.string.edited, film.getEdited()));
        filmCreated.setText(getString(R.string.created, film.getCreated()));

        filmCharacters.setAdapter(minPersonAdapter);
        filmSpecies.setAdapter(minSpeciesResultAdapter);
        filmVehicles.setAdapter(minVehicleAdapter);
        filmStarships.setAdapter(minStarshipAdapter);
        filmPlanets.setAdapter(minPlanetAdapter);

        filmCharacters.setLayoutManager(new LinearLayoutManager(ViewFilm.this));
        filmSpecies.setLayoutManager(new LinearLayoutManager(ViewFilm.this));
        filmVehicles.setLayoutManager(new LinearLayoutManager(ViewFilm.this));
        filmStarships.setLayoutManager(new LinearLayoutManager(ViewFilm.this));
        filmPlanets.setLayoutManager(new LinearLayoutManager(ViewFilm.this));
    }
}

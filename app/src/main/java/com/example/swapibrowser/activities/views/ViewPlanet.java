package com.example.swapibrowser.activities.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.ItemAdapterMin;
import com.example.swapibrowser.models.planet.Planet;
import com.example.swapibrowser.utils.PageSaver;

public class ViewPlanet extends AppCompatActivity {

    Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_field_layout);

        TextView planetName = findViewById(R.id.planet_name);
        TextView planetRotationPeriod = findViewById(R.id.planet_rotational_period);
        TextView planetOrbitalPeriod = findViewById(R.id.planet_orbital_period);
        TextView planetDiameter = findViewById(R.id.planet_diameter);
        TextView planetClimate = findViewById(R.id.planet_climate);
        TextView planetGravity = findViewById(R.id.planet_gravity);
        TextView planetTerrain = findViewById(R.id.planet_terrain);
        TextView planetSurfaceWater = findViewById(R.id. planet_surface_water);
        TextView planetPopulation = findViewById(R.id.planet_population);
        TextView planetCreated = findViewById(R.id.planet_created);
        TextView planetEdited = findViewById(R.id.planet_edited);

        RecyclerView planetResidents = findViewById(R.id.planet_residents_recycler);
        RecyclerView planetFilms = findViewById(R.id.planet_films_recycler);

        favorite = findViewById(R.id.favorite);
        checkButton();

        Intent intent = getIntent();
        Planet planet = (Planet) intent.getSerializableExtra("planets");

        ItemAdapterMin minFilmAdapter = new ItemAdapterMin(planet.getFilms(), ViewPlanet.this, "films");
        ItemAdapterMin minPersonAdapter = new ItemAdapterMin(planet.getResidents(), ViewPlanet.this, "people");

        planetName.setText(getString(R.string.name, planet.getName()));
        planetRotationPeriod.setText(getString(R.string.planet_rotational_period, planet.getRotationPeriod()));
        planetOrbitalPeriod.setText(getString(R.string.planet_orbital_period, planet.getOrbitalPeriod()));
        planetDiameter.setText(getString(R.string.planet_diameter, planet.getDiameter()));
        planetClimate.setText(getString(R.string.planet_climate, planet.getClimate()));
        planetGravity.setText(getString(R.string.planet_gravity, planet.getGravity()));
        planetTerrain.setText(getString(R.string.planet_terrain, planet.getTerrain()));
        planetSurfaceWater.setText(getString(R.string.planet_water, planet.getSurfaceWater()));
        planetPopulation.setText(getString(R.string.planet_population, planet.getPopulation()));
        planetEdited.setText(getString(R.string.edited, planet.getEdited()));
        planetCreated.setText(getString(R.string.created, planet.getCreated()));

        planetFilms.setAdapter(minFilmAdapter);
        planetResidents.setAdapter(minPersonAdapter);

        planetFilms.setLayoutManager(new LinearLayoutManager(ViewPlanet.this));
        planetResidents.setLayoutManager(new LinearLayoutManager(ViewPlanet.this));
    }

    public void saveFavorite(View view) {
        PageSaver saver = new PageSaver();
        favorite.setText(R.string.favorited);
        saver.saveFavorite(this);
    }

    public void checkButton(){
        PageSaver saver = new PageSaver();
        if (!saver.check(saver.read(this), this)) {
            favorite.setText(R.string.favorited);
        }

    }
}

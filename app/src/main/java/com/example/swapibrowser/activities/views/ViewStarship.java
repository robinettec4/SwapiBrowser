package com.example.swapibrowser.activities.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.min.MinFilmAdapter;
import com.example.swapibrowser.adapters.min.MinPersonAdapter;
import com.example.swapibrowser.models.starship.Starship;

public class ViewStarship extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starship_field_layout);

         TextView starshipName = findViewById(R.id.starship_name);
         TextView starshipModel = findViewById(R.id.starship_model);
         TextView starshipManufacturer = findViewById(R.id.starship_manufacturer);
         TextView starshipCost = findViewById(R.id.starhship_cost);
         TextView starshipLength = findViewById(R.id.starship_length);
         TextView starshipMaxSpeed = findViewById(R.id.starship_max_speed);
         TextView starshipCrew = findViewById(R.id.starship_crew);
         TextView starshipPassengers = findViewById(R.id.starship_passengers);
         TextView starshipCargo = findViewById(R.id.starship_cargo);
         TextView starshipConsumables = findViewById(R.id.starship_consumables);
         TextView starshipHyperDriveRating = findViewById(R.id.starship_hyperdrive_rating);
         TextView starshipMGLT = findViewById(R.id.starship_mglt);
         TextView starshipClass = findViewById(R.id.starship_class);
         TextView starshipCreated = findViewById(R.id.starship_created);
         TextView starshipEdited = findViewById(R.id.starship_edited);

         RecyclerView starshipPilots = findViewById(R.id.starship_people_recycler);
         RecyclerView starshipFilms = findViewById(R.id.starship_films_recycler);

        Intent intent = getIntent();
        Starship starship = (Starship) intent.getSerializableExtra("starships");

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(starship.getFilms(), ViewStarship.this);
        MinPersonAdapter minPersonAdapter = new MinPersonAdapter(starship.getPilots(), ViewStarship.this);

        starshipName.setText(getString(R.string.name,  starship.getName()));
        starshipModel.setText(getString(R.string.model, starship.getModel()));
        starshipManufacturer.setText(getString(R.string.manufacturer, starship.getManufacturer()));
        starshipCost.setText(getString(R.string.cost, starship.getCostInCredits()));
        starshipLength.setText(getString(R.string.length, starship.getLength()));
        starshipMaxSpeed.setText(getString(R.string.max_speed, starship.getMaxAtmospheringSpeed()));
        starshipCrew.setText(getString(R.string.crew, starship.getCrew()));
        starshipPassengers.setText(getString(R.string.passengers, starship.getPassengers()));
        starshipCargo.setText(getString(R.string.cargo, starship.getCargoCapacity()));
        starshipConsumables.setText(getString(R.string.consumables, starship.getConsumables()));
        starshipHyperDriveRating.setText(getString(R.string.starship_hyper_drive_rating, starship.getHyperdriveRating()));
        starshipMGLT.setText(getString(R.string.starship_mglt, starship.getMGLT()));
        starshipClass.setText(getString(R.string.s_class, starship.getStarshipClass()));
        starshipEdited.setText(getString(R.string.edited, starship.getEdited()));
        starshipCreated.setText(getString(R.string.created, starship.getCreated()));

        starshipFilms.setAdapter(minFilmAdapter);
        starshipPilots.setAdapter(minPersonAdapter);

        starshipFilms.setLayoutManager(new LinearLayoutManager(ViewStarship.this));
        starshipPilots.setLayoutManager(new LinearLayoutManager(ViewStarship.this));
    }
}

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
import com.example.swapibrowser.models.starship.Starship;
import com.example.swapibrowser.utils.PageSaver;

public class ViewStarship extends AppCompatActivity {

    Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starship_field_layout);

        TextView starshipName = findViewById(R.id.starship_name);
        TextView starshipModel = findViewById(R.id.starship_model);
        TextView starshipManufacturer = findViewById(R.id.starship_manufacturer);
        TextView starshipCost = findViewById(R.id.starship_cost);
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

        favorite = findViewById(R.id.favorite);
        checkButton();

        Intent intent = getIntent();
        Starship starship = (Starship) intent.getSerializableExtra("starships");

        ItemAdapterMin minFilmAdapter = new ItemAdapterMin(starship.getFilms(), ViewStarship.this, "films");
        ItemAdapterMin minPersonAdapter = new ItemAdapterMin(starship.getPilots(), ViewStarship.this, "people");

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

    public void editFavorite(View view) {
        PageSaver saver = new PageSaver();
        if (favorite.getText().toString().equals(getString(R.string.favorite))) {
            favorite.setText(R.string.unfavorite);
            saver.saveFavorite(this);
        }
        else {
            favorite.setText(R.string.favorite);
            saver.removeFavorite(this);
        }
    }

    public void checkButton(){
        PageSaver saver = new PageSaver();
        if (!saver.check(saver.read(this), this)) {
            favorite.setText(R.string.unfavorite);
        }
        else {
            favorite.setText(R.string.favorite);
        }
    }
}

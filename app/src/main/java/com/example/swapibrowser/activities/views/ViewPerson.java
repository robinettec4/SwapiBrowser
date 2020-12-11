package com.example.swapibrowser.activities.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.min.MinFilmAdapter;
import com.example.swapibrowser.adapters.min.MinSpeciesResultAdapter;
import com.example.swapibrowser.adapters.min.MinStarshipAdapter;
import com.example.swapibrowser.adapters.min.MinVehicleAdapter;
import com.example.swapibrowser.models.person.Person;

public class ViewPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_field_layout);

         TextView personName = findViewById(R.id.person_name);
         TextView personHeight = findViewById(R.id.person_height);
         TextView personMass = findViewById(R.id.person_mass);
         TextView personHairColor = findViewById(R.id.person_hair_color);
         TextView personSkinColor = findViewById(R.id.person_skin_color);
         TextView personEyeColor = findViewById(R.id.person_eye_color);
         TextView personBirthYear = findViewById(R.id.person_birth_year);
         TextView personGender = findViewById(R.id.person_gender);
         TextView personHomeWorld = findViewById(R.id.person_homeworld);
         TextView  personCreated = findViewById(R.id.person_created);
         TextView personEdited = findViewById(R.id.person_edited);

         RecyclerView personFilms = findViewById(R.id.person_films_recycler);
         RecyclerView personSpecies = findViewById(R.id.person_species_recycler);
         RecyclerView personVehicles = findViewById(R.id.person_vehicles_recycler);
         RecyclerView personStarships = findViewById(R.id.person_starships_recycler);

        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("people");

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(person.getFilms(), ViewPerson.this);
        MinSpeciesResultAdapter minSpeciesResultAdapter = new MinSpeciesResultAdapter(person.getSpecies(), ViewPerson.this);
        MinVehicleAdapter minVehicleAdapter = new MinVehicleAdapter(person.getVehicles(), ViewPerson.this);
        MinStarshipAdapter minStarshipAdapter = new MinStarshipAdapter(person.getStarships(), ViewPerson.this);

        personName.setText(getString(R.string.name, person.getName()));
        personHeight.setText(getString(R.string.person_height, person.getHeight()));
        personMass.setText(getString(R.string.person_mass, person.getMass()));
        personHairColor.setText(getString(R.string.person_hair_color, person.getHairColor()));
        personSkinColor.setText(getString(R.string.person_skin_color, person.getSkinColor()));
        personEyeColor.setText(getString(R.string.person_eye_color, person.getEyeColor()));
        personBirthYear.setText(getString(R.string.person_birth_year, person.getBirthYear()));
        personGender.setText(getString(R.string.person_gender, person.getGender()));
        personHomeWorld.setText(getString(R.string.homeworld, person.getHomeworld()));
        personCreated.setText(getString(R.string.created, person.getCreated()));
        personEdited.setText(getString(R.string.edited, person.getEdited()));

        personFilms.setAdapter(minFilmAdapter);
        personSpecies.setAdapter(minSpeciesResultAdapter);
        personVehicles.setAdapter(minVehicleAdapter);
        personStarships.setAdapter(minStarshipAdapter);

        personFilms.setLayoutManager(new LinearLayoutManager(ViewPerson.this));
        personSpecies.setLayoutManager(new LinearLayoutManager(ViewPerson.this));
        personVehicles.setLayoutManager(new LinearLayoutManager(ViewPerson.this));
        personStarships.setLayoutManager(new LinearLayoutManager(ViewPerson.this));
    }
}

package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class PersonHolder extends RecyclerView.ViewHolder {

    public TextView personName;
    public TextView personNameMin;
    public TextView personHeight;
    public TextView personMass;
    public TextView personHairColor;
    public TextView personSkinColor;
    public TextView personEyeColor;
    public TextView personBirthYear;
    public TextView personGender;
    public TextView personHomeWorld;
    public RecyclerView personFilms;
    public RecyclerView personSpecies;
    public RecyclerView personVehicles;
    public RecyclerView personStarships;
    public TextView personCreated;
    public TextView personEdited;

    public PersonHolder(@NonNull View itemView) {
        super(itemView);
        personName = itemView.findViewById(R.id.person_name);
        personNameMin = itemView.findViewById(R.id.person_name_min);
        personHeight = itemView.findViewById(R.id.person_height);
        personMass = itemView.findViewById(R.id.person_mass);
        personHairColor = itemView.findViewById(R.id.person_hair_color);
        personSkinColor = itemView.findViewById(R.id.person_skin_color);
        personEyeColor = itemView.findViewById(R.id.person_eye_color);
        personBirthYear = itemView.findViewById(R.id.person_birth_year);
        personGender = itemView.findViewById(R.id.person_gender);
        personHomeWorld = itemView.findViewById(R.id.person_homeworld);
        personFilms = itemView.findViewById(R.id.person_films_recycler);
        personSpecies = itemView.findViewById(R.id.person_species_recycler);
        personVehicles = itemView.findViewById(R.id.person_vehicles_recycler);
        personStarships = itemView.findViewById(R.id.person_starships_recycler);
        personCreated = itemView.findViewById(R.id.person_created);
        personEdited = itemView.findViewById(R.id.person_edited);
    }
}

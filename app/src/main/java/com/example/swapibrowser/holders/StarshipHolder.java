package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class StarshipHolder extends RecyclerView.ViewHolder {

    public TextView starshipNameMin;
    public TextView starshipName;
    public TextView starshipModel;
    public TextView starshipManufacturer;
    public TextView starshipCost;
    public TextView starshipLength;
    public TextView starshipMaxSpeed;
    public TextView starshipCrew;
    public TextView starshipPassengers;
    public TextView starshipCargo;
    public TextView starshipConsumables;
    public TextView starshipHyperDriveRating;
    public TextView starshipMGLT;
    public TextView starshipClass;
    public TextView starshipCreated;
    public TextView starshipEdited;

    public RecyclerView starshipPilots;
    public RecyclerView starshipFilms;

    public StarshipHolder(@NonNull View itemView) {
        super(itemView);
        starshipNameMin = itemView.findViewById(R.id.starship_name_min);
        starshipName = itemView.findViewById(R.id.starship_name);
        starshipModel = itemView.findViewById(R.id.starship_model);
        starshipManufacturer = itemView.findViewById(R.id.starship_manufacturer);
        starshipCost = itemView.findViewById(R.id.starhship_cost);
        starshipLength = itemView.findViewById(R.id.starship_length);
        starshipMaxSpeed = itemView.findViewById(R.id.starship_max_speed);
        starshipCrew = itemView.findViewById(R.id.starship_crew);
        starshipPassengers = itemView.findViewById(R.id.starship_passengers);
        starshipCargo = itemView.findViewById(R.id.starship_cargo);
        starshipConsumables = itemView.findViewById(R.id.starship_consumables);
        starshipHyperDriveRating = itemView.findViewById(R.id.starship_hyperdrive_rating);
        starshipMGLT = itemView.findViewById(R.id.starship_mglt);
        starshipClass = itemView.findViewById(R.id.starship_class);
        starshipCreated = itemView.findViewById(R.id.starship_created);
        starshipEdited = itemView.findViewById(R.id.starship_edited);

        starshipPilots = itemView.findViewById(R.id.starship_people_recycler);
        starshipFilms = itemView.findViewById(R.id.starship_films_recycler);
    }
}

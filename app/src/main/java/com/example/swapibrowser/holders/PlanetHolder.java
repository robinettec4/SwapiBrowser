package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class PlanetHolder extends RecyclerView.ViewHolder {

    public TextView planetNameMin;
    public TextView planetName;
    public TextView planetRotationPeriod;
    public TextView planetOrbitalPeriod;
    public TextView planetDiameter;
    public TextView planetClimate;
    public TextView planetGravity;
    public TextView planetTerrain;
    public TextView planetSurfaceWater;
    public TextView planetPopulation;
    public TextView planetCreated;
    public TextView planetEdited;

    public RecyclerView planetResidents;
    public RecyclerView planetFilms;

    public PlanetHolder(@NonNull View itemView) {
        super(itemView);
        planetNameMin = itemView.findViewById(R.id.planet_name_min);
        planetName = itemView.findViewById(R.id.planet_name);
        planetRotationPeriod = itemView.findViewById(R.id.planet_rotational_period);
        planetOrbitalPeriod = itemView.findViewById(R.id.planet_orbital_period);
        planetDiameter = itemView.findViewById(R.id.planet_diameter);
        planetClimate = itemView.findViewById(R.id.planet_climate);
        planetGravity = itemView.findViewById(R.id.planet_gravity);
        planetTerrain = itemView.findViewById(R.id.planet_terrain);
        planetSurfaceWater = itemView.findViewById(R.id. planet_surface_water);
        planetPopulation = itemView.findViewById(R.id.planet_population);
        planetCreated = itemView.findViewById(R.id.planet_created);
        planetEdited = itemView.findViewById(R.id.planet_edited);

        planetResidents = itemView.findViewById(R.id.planet_residents_recycler);
        planetFilms = itemView.findViewById(R.id.planet_films_recycler);
    }
}

package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class SpeciesResultHolder extends RecyclerView.ViewHolder {

    public TextView speciesNameMin;
    public TextView speciesName;
    public TextView speciesClassification;
    public TextView speciesDesignation;
    public TextView speciesAvgHeight;
    public TextView speciesSkinColors;
    public TextView speciesHairColors;
    public TextView speciesEyeColors;
    public TextView speciesAvgLifespan;
    public TextView speciesHomeworld;
    public TextView speciesLanguage;
    public TextView speciesEdited;
    public TextView speciesCreated;

    public RecyclerView speciesPeople;
    public RecyclerView speciesFilms;
    

    public SpeciesResultHolder(@NonNull View itemView) {
        super(itemView);
        speciesNameMin = itemView.findViewById(R.id.species_name_min);
        speciesName = itemView.findViewById(R.id.species_name);
        speciesClassification = itemView.findViewById(R.id.species_classification);
        speciesDesignation = itemView.findViewById(R.id.species_designation);
        speciesAvgHeight = itemView.findViewById(R.id.species_avg_height);
        speciesAvgLifespan = itemView.findViewById(R.id.species_avg_lifespan);
        speciesSkinColors = itemView.findViewById(R.id.species_skin_colors);
        speciesHairColors = itemView.findViewById(R.id.species_hair_colors);
        speciesEyeColors = itemView.findViewById(R.id.species_eye_colors);
        speciesHomeworld = itemView.findViewById(R.id.species_homeworld);
        speciesLanguage = itemView.findViewById(R.id.species_language);
        speciesEdited = itemView.findViewById(R.id.species_edited);
        speciesCreated = itemView.findViewById(R.id.species_created);

        speciesPeople = itemView.findViewById(R.id.species_people_recycler);
        speciesFilms = itemView.findViewById(R.id.species_films_recycler);
    }
}

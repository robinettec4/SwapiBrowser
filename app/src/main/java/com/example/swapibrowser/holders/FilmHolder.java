package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class FilmHolder extends RecyclerView.ViewHolder {

    public TextView filmTitleMin;
    public TextView filmTitle;
    public TextView filmEpisodeId;
    public TextView filmOpeningCrawl;
    public TextView filmDirector;
    public TextView filmProducer;
    public TextView filmReleaseDate;
    public TextView filmEdited;
    public TextView filmCreated;
    public RecyclerView filmCharacters;
    public RecyclerView filmPlanets;
    public RecyclerView filmStarships;
    public RecyclerView filmVehicles;
    public RecyclerView filmSpecies;

    public FilmHolder(@NonNull View itemView) {
        super(itemView);
        filmTitleMin = itemView.findViewById(R.id.film_title_min);
        filmTitle = itemView.findViewById(R.id.film_title);
        filmEpisodeId = itemView.findViewById(R.id.film_episode_id);
        filmOpeningCrawl = itemView.findViewById(R.id.film_opening_crawl);
        filmDirector = itemView.findViewById(R.id.film_director);
        filmProducer = itemView.findViewById(R.id.film_producer);
        filmReleaseDate = itemView.findViewById(R.id.film_release_date);
        filmEdited = itemView.findViewById(R.id.film_edited);
        filmCreated = itemView.findViewById(R.id.film_created);
        filmCharacters = itemView.findViewById(R.id.film_characters_recycler);
        filmPlanets = itemView.findViewById(R.id.film_planets_recycler);
        filmStarships = itemView.findViewById(R.id.film_starships_recycler);
        filmVehicles = itemView.findViewById(R.id.film_vehicles_recycler);
        filmSpecies = itemView.findViewById(R.id.film_species_recycler);
    }
}

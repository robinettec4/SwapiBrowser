package com.example.swapibrowser.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.min.MinPersonAdapter;
import com.example.swapibrowser.adapters.min.MinPlanetAdapter;
import com.example.swapibrowser.adapters.min.MinSpeciesResultAdapter;
import com.example.swapibrowser.adapters.min.MinStarshipAdapter;
import com.example.swapibrowser.adapters.min.MinVehicleAdapter;
import com.example.swapibrowser.holders.FilmHolder;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.film.Film;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;

    public FilmAdapter(List<ISingleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_field_layout, parent, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {

        Film film = (Film) list.get(position);
        
        MinPersonAdapter minPersonAdapter = new MinPersonAdapter(film.getCharacters(), context);
        MinSpeciesResultAdapter minSpeciesResultAdapter = new MinSpeciesResultAdapter(film.getSpecies(), context);
        MinVehicleAdapter minVehicleAdapter = new MinVehicleAdapter(film.getVehicles(), context);
        MinStarshipAdapter minStarshipAdapter = new MinStarshipAdapter(film.getStarships(), context);
        MinPlanetAdapter minPlanetAdapter = new MinPlanetAdapter(film.getPlanets(), context);

        holder.filmTitle.setText(context.getString(R.string.film_title, film.getTitle()));
        holder.filmEpisodeId.setText(context.getString(R.string.film_episode_id, film.getEpisodeId()));
        holder.filmOpeningCrawl.setText(context.getString(R.string.film_opening_crawl, film.getOpeningCrawl()));
        holder.filmDirector.setText(context.getString(R.string.film_director, film.getDirector()));
        holder.filmProducer.setText(context.getString(R.string.film_producer, film.getProducer()));
        holder.filmReleaseDate.setText(context.getString(R.string.film_release_date, film.getReleaseDate()));
        holder.filmEdited.setText(context.getString(R.string.edited, film.getEdited()));
        holder.filmCreated.setText(context.getString(R.string.created, film.getCreated()));

        holder.filmCharacters.setAdapter(minPersonAdapter);
        holder.filmSpecies.setAdapter(minSpeciesResultAdapter);
        holder.filmVehicles.setAdapter(minVehicleAdapter);
        holder.filmStarships.setAdapter(minStarshipAdapter);
        holder.filmPlanets.setAdapter(minPlanetAdapter);

        holder.filmCharacters.setLayoutManager(new LinearLayoutManager(context));
        holder.filmSpecies.setLayoutManager(new LinearLayoutManager(context));
        holder.filmVehicles.setLayoutManager(new LinearLayoutManager(context));
        holder.filmStarships.setLayoutManager(new LinearLayoutManager(context));
        holder.filmPlanets.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

package com.example.swapibrowser.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.min.MinFilmAdapter;
import com.example.swapibrowser.adapters.min.MinPersonAdapter;
import com.example.swapibrowser.holders.PlanetHolder;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.planet.Planet;

import java.util.Collections;
import java.util.List;

public class PlanetAdapter  extends RecyclerView.Adapter<PlanetHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;

    public PlanetAdapter(List<ISingleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_field_layout, parent, false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {

        Planet planet = (Planet) list.get(position);

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(planet.getFilms(), context);
        MinPersonAdapter minPersonAdapter = new MinPersonAdapter(planet.getResidents(), context);

        holder.planetName.setText(context.getString(R.string.name, planet.getName()));
        holder.planetRotationPeriod.setText(context.getString(R.string.planet_rotational_period, planet.getRotationPeriod()));
        holder.planetOrbitalPeriod.setText(context.getString(R.string.planet_orbital_period, planet.getOrbitalPeriod()));
        holder.planetDiameter.setText(context.getString(R.string.planet_diameter, planet.getDiameter()));
        holder.planetClimate.setText(context.getString(R.string.planet_climate, planet.getClimate()));
        holder.planetGravity.setText(context.getString(R.string.planet_gravity, planet.getGravity()));
        holder.planetTerrain.setText(context.getString(R.string.planet_terrain, planet.getTerrain()));
        holder.planetSurfaceWater.setText(context.getString(R.string.planet_water, planet.getSurfaceWater()));
        holder.planetPopulation.setText(context.getString(R.string.planet_population, planet.getPopulation()));
        holder.planetEdited.setText(context.getString(R.string.edited, planet.getEdited()));
        holder.planetCreated.setText(context.getString(R.string.created, planet.getCreated()));

        holder.planetFilms.setAdapter(minFilmAdapter);
        holder.planetResidents.setAdapter(minPersonAdapter);

        holder.planetFilms.setLayoutManager(new LinearLayoutManager(context));
        holder.planetResidents.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

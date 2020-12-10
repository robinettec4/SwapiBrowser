package com.example.swapibrowser.adapters.min;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.PlanetsGenerator;
import com.example.swapibrowser.holders.PlanetHolder;
import com.example.swapibrowser.models.planet.Planet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinPlanetAdapter extends RecyclerView.Adapter<PlanetHolder> {

    List<String> list = Collections.emptyList();
    Context context;
    PlanetsGenerator planetsGenerator = new PlanetsGenerator();
    ArrayList<Planet> planets = new ArrayList<>();

    public MinPlanetAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        getPlanets(list);
    }

    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_field_layout_min, parent, false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {
        if(!planets.isEmpty()) {
            holder.planetNameMin.setText(planets.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public void getPlanets(List<String> list) {

        ApiResponseListener<Planet> planetListener = new ApiResponseListener<Planet>() {
            @Override
            public void onResponseReceived(Planet response) {
                planets.add(response);
                notifyItemInserted(planets.size() - 1);
            }
            @Override
            public void onError(Throwable error) {
                System.out.println(error.getMessage());
            }
        };

        for(String s: list) {
            planetsGenerator.getByFullUrl(s, planetListener);
        }
    }
}

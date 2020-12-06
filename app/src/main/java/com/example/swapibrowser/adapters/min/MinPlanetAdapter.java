package com.example.swapibrowser.adapters.min;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.holders.PlanetHolder;
import com.example.swapibrowser.models.planet.Planet;

import java.util.Collections;
import java.util.List;

public class MinPlanetAdapter extends RecyclerView.Adapter<PlanetHolder> {

    List<Planet> list = Collections.emptyList();
    Context context;

    public MinPlanetAdapter(List<Planet> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_field_layout_min, parent, false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {
        holder.planetName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

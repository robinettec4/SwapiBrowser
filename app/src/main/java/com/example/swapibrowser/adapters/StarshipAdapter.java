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
import com.example.swapibrowser.adapters.min.MinSpeciesResultAdapter;
import com.example.swapibrowser.adapters.min.MinStarshipAdapter;
import com.example.swapibrowser.adapters.min.MinVehicleAdapter;
import com.example.swapibrowser.holders.FilmHolder;
import com.example.swapibrowser.holders.StarshipHolder;
import com.example.swapibrowser.models.starship.Starship;
import com.example.swapibrowser.models.starship.Starship;

import java.util.Collections;
import java.util.List;

public class StarshipAdapter  extends RecyclerView.Adapter<StarshipHolder> {

    List<Starship> list = Collections.emptyList();
    Context context;

    public StarshipAdapter(List<Starship> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StarshipHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.starship_field_layout, parent, false);
        return new StarshipHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipHolder holder, int position) {

        Starship starship = list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

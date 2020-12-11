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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_recycler_layout, parent, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {
        Film film = (Film) list.get(position);
        holder.filmCardTitle.setText(context.getString(R.string.film_title, film.getTitle()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

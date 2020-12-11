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
import com.example.swapibrowser.holders.StarshipHolder;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.starship.Starship;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StarshipAdapter  extends RecyclerView.Adapter<StarshipHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;

    public StarshipAdapter(List<ISingleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StarshipHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.starship_recycler_layout, parent, false);
        return new StarshipHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipHolder holder, int position) {
        Starship starship = (Starship) list.get(position);
        holder.starshipCardName.setText(context.getString(R.string.name,  starship.getName()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

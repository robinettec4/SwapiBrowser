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
import com.example.swapibrowser.holders.SpeciesResultHolder;
import com.example.swapibrowser.models.species.SpeciesResult;

import java.util.Collections;
import java.util.List;

public class SpeciesResultAdapter  extends RecyclerView.Adapter<SpeciesResultHolder> {

    List<SpeciesResult> list = Collections.emptyList();
    Context context;

    public SpeciesResultAdapter(List<SpeciesResult> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SpeciesResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.species_field_layout, parent, false);
        return new SpeciesResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesResultHolder holder, int position) {

        SpeciesResult speciesResult = list.get(position);

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(speciesResult.getFilms(), context);
        MinPersonAdapter minPersonAdapter = new MinPersonAdapter(speciesResult.getPeople(), context);

        holder.speciesName.setText(speciesResult.getName());
        holder.speciesClassification.setText(speciesResult.getClassification());
        holder.speciesDesignation.setText(speciesResult.getDesignation());
        holder.speciesAvgHeight.setText(speciesResult.getAverageHeight());
        holder.speciesSkinColors.setText(speciesResult.getSkinColors());
        holder.speciesHairColors.setText(speciesResult.getHairColors());
        holder.speciesEyeColors.setText(speciesResult.getEyeColors());
        holder.speciesAvgLifespan.setText(speciesResult.getAverageLifespan());
        holder.speciesHomeworld.setText(speciesResult.getHomeworld());
        holder.speciesLanguage.setText(speciesResult.getLanguage());
        holder.speciesEdited.setText(speciesResult.getEdited());
        holder.speciesCreated.setText(speciesResult.getCreated());

        holder.speciesFilms.setAdapter(minFilmAdapter);
        holder.speciesPeople.setAdapter(minPersonAdapter);

        holder.speciesFilms.setLayoutManager(new LinearLayoutManager(context));
        holder.speciesPeople.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

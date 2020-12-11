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
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.species.SpeciesResult;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class SpeciesResultAdapter  extends RecyclerView.Adapter<SpeciesResultHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;

    public SpeciesResultAdapter(List<ISingleModel> list, Context context) {
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

        SpeciesResult speciesResult = (SpeciesResult) list.get(position);

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(speciesResult.getFilms(), context);
        MinPersonAdapter minPersonAdapter = new MinPersonAdapter(speciesResult.getPeople(), context);

        holder.speciesName.setText(context.getString(R.string.name, speciesResult.getName()));
        holder.speciesClassification.setText(context.getString(R.string.s_class, speciesResult.getClassification()));
        holder.speciesDesignation.setText(context.getString(R.string.species_designation, speciesResult.getDesignation()));
        holder.speciesAvgHeight.setText(context.getString(R.string.species_average_height, speciesResult.getAverageHeight()));
        holder.speciesSkinColors.setText(context.getString(R.string.species_skin_colors, speciesResult.getSkinColors()));
        holder.speciesHairColors.setText(context.getString(R.string.species_hair_colors, speciesResult.getHairColors()));
        holder.speciesEyeColors.setText(context.getString(R.string.species_eye_colors, speciesResult.getEyeColors()));
        holder.speciesAvgLifespan.setText(context.getString(R.string.species_average_lifespan, speciesResult.getAverageLifespan()));
        holder.speciesHomeworld.setText(context.getString(R.string.homeworld, speciesResult.getHomeworld()));
        holder.speciesLanguage.setText(context.getString(R.string.species_language, speciesResult.getLanguage()));
        holder.speciesEdited.setText(context.getString(R.string.edited, speciesResult.getEdited()));
        holder.speciesCreated.setText(context.getString(R.string.created, speciesResult.getCreated()));

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

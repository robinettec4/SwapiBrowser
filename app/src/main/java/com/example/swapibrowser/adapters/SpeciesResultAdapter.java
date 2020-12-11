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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.species_recycler_layout, parent, false);
        return new SpeciesResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesResultHolder holder, int position) {
        SpeciesResult speciesResult = (SpeciesResult) list.get(position);
        holder.speciesCardName.setText(context.getString(R.string.name, speciesResult.getName()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

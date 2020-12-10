package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class SpeciesResultHolder extends RecyclerView.ViewHolder {

    public TextView speciesNameMin;

    public SpeciesResultHolder(@NonNull View itemView) {
        super(itemView);
        speciesNameMin = itemView.findViewById(R.id.species_name_min);
    }
}

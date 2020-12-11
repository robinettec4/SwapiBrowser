package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class SpeciesResultHolder extends RecyclerView.ViewHolder {

    public TextView speciesNameMin;
    public TextView speciesCardName;
    public CardView speciesCardView;
    

    public SpeciesResultHolder(@NonNull View itemView) {
        super(itemView);
        speciesNameMin = itemView.findViewById(R.id.species_name_min);
        speciesCardName = itemView.findViewById(R.id.species_card_name);
        speciesCardView = itemView.findViewById(R.id.species_card);
    }
}

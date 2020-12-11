package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class PlanetHolder extends RecyclerView.ViewHolder {

    public TextView planetNameMin;
    public TextView planetCardName;
    public CardView planetCardView;

    public PlanetHolder(@NonNull View itemView) {
        super(itemView);
        planetNameMin = itemView.findViewById(R.id.planet_name_min);
        planetCardName = itemView.findViewById(R.id.planet_card_name);
        planetCardView = itemView.findViewById(R.id.planet_card);
    }
}

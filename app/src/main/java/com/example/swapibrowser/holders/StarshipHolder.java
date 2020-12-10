package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class StarshipHolder extends RecyclerView.ViewHolder {

    public TextView starshipNameMin;

    public StarshipHolder(@NonNull View itemView) {
        super(itemView);
        starshipNameMin = itemView.findViewById(R.id.starship_name_min);
    }
}

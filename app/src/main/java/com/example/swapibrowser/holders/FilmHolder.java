package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class FilmHolder extends RecyclerView.ViewHolder {

    public TextView filmTitleMin;
    public TextView filmCardTitle;

    public FilmHolder(@NonNull View itemView) {
        super(itemView);
        filmTitleMin = itemView.findViewById(R.id.film_title_min);
        filmCardTitle = itemView.findViewById(R.id.film_card_title);
    }
}

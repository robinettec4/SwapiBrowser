package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class FilmHolder extends RecyclerView.ViewHolder {

    public TextView filmName;

    public FilmHolder(@NonNull View itemView) {
        super(itemView);
        filmName = itemView.findViewById(R.id.film_name_min);
    }
}

package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class PersonHolder extends RecyclerView.ViewHolder {

    public TextView personNameMin;
    public TextView personCardName;

    public PersonHolder(@NonNull View itemView) {
        super(itemView);
        personNameMin = itemView.findViewById(R.id.person_name_min);
        personCardName = itemView.findViewById(R.id.person_card_name);
    }
}

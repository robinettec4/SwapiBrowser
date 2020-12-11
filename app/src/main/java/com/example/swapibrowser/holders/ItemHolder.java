package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class ItemHolder extends RecyclerView.ViewHolder {

    public TextView itemNameMin;
    public TextView itemCardName;
    public CardView itemCardView;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        itemNameMin = itemView.findViewById(R.id.item_name_min);
        itemCardName = itemView.findViewById(R.id.item_card_name);
        itemCardView = itemView.findViewById(R.id.item_card);
    }
}

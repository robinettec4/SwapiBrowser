package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class VehicleHolder extends RecyclerView.ViewHolder {

    public TextView vehicleNameMin;
    public TextView vehicleCardName;
    public CardView vehicleCardView;

    public VehicleHolder(@NonNull View itemView) {
        super(itemView);
        vehicleNameMin = itemView.findViewById(R.id.vehicle_name_min);
        vehicleCardName = itemView.findViewById(R.id.vehicle_card_name);
        vehicleCardView = itemView.findViewById(R.id.vehicle_card);
    }
}

package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class VehicleHolder extends RecyclerView.ViewHolder {

    public TextView vehicleName;

    public VehicleHolder(@NonNull View itemView) {
        super(itemView);
        vehicleName = itemView.findViewById(R.id.vehicle_name_min);
    }
}

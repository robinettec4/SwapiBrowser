package com.example.swapibrowser.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class VehicleHolder extends RecyclerView.ViewHolder {

    public TextView vehicleNameMin;
    public TextView vehicleName;
    public TextView vehicleModel;
    public TextView vehicleManufacturer;
    public TextView vehicleCost;
    public TextView vehicleLength;
    public TextView vehicleMaxSpeed;
    public TextView vehicleCrew;
    public TextView vehiclePassengers;
    public TextView vehicleCargo;
    public TextView vehicleConsumables;
    public TextView vehicleClass;
    public TextView vehicleCreated;
    public TextView vehicleEdited;

    public RecyclerView vehiclePilots;
    public RecyclerView vehicleFilms;

    public VehicleHolder(@NonNull View itemView) {
        super(itemView);
        vehicleNameMin = itemView.findViewById(R.id.vehicle_name_min);
        vehicleNameMin = itemView.findViewById(R.id.vehicle_name_min);
        vehicleName = itemView.findViewById(R.id.vehicle_name);
        vehicleModel = itemView.findViewById(R.id.vehicle_model);
        vehicleManufacturer = itemView.findViewById(R.id.vehicle_manufacturer);
        vehicleCost = itemView.findViewById(R.id.vehicle_cost);
        vehicleLength = itemView.findViewById(R.id.vehicle_length);
        vehicleMaxSpeed = itemView.findViewById(R.id.vehicle_max_speed);
        vehicleCrew = itemView.findViewById(R.id.vehicle_crew);
        vehiclePassengers = itemView.findViewById(R.id.vehicle_passengers);
        vehicleCargo = itemView.findViewById(R.id.vehicle_cargo);
        vehicleConsumables = itemView.findViewById(R.id.vehicle_consumables);
        vehicleClass = itemView.findViewById(R.id.vehicle_class);
        vehicleCreated = itemView.findViewById(R.id.vehicle_created);
        vehicleEdited = itemView.findViewById(R.id.vehicle_edited);

        vehiclePilots = itemView.findViewById(R.id.vehicle_people_recycler);
        vehicleFilms = itemView.findViewById(R.id.vehicle_films_recycler);
    }
}

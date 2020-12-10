package com.example.swapibrowser.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.min.MinFilmAdapter;
import com.example.swapibrowser.adapters.min.MinPersonAdapter;
import com.example.swapibrowser.holders.VehicleHolder;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.vehicle.Vehicle;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class VehicleAdapter  extends RecyclerView.Adapter<VehicleHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;

    public VehicleAdapter(List<ISingleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VehicleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_field_layout, parent, false);
        return new VehicleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleHolder holder, int position) {

        Vehicle vehicle = (Vehicle) list.get(position);

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(vehicle.getFilms(), context);
        MinPersonAdapter minPersonAdapter = new MinPersonAdapter(vehicle.getPilots(), context);

        holder.vehicleName.setText(vehicle.getName());
        holder.vehicleModel.setText(vehicle.getModel());
        holder.vehicleManufacturer.setText(vehicle.getManufacturer());
        holder.vehicleCost.setText(vehicle.getCostInCredits());
        holder.vehicleLength.setText(vehicle.getLength());
        holder.vehicleMaxSpeed.setText(vehicle.getMaxAtmospheringSpeed());
        holder.vehicleCreated.setText(vehicle.getCrew());
        holder.vehiclePassengers.setText(vehicle.getPassengers());
        holder.vehicleCargo.setText(vehicle.getCargoCapacity());
        holder.vehicleConsumables.setText(vehicle.getConsumables());
        holder.vehicleClass.setText(vehicle.getVehicleClass());
        holder.vehicleEdited.setText(vehicle.getEdited());
        holder.vehicleCreated.setText(vehicle.getCreated());

        holder.vehicleFilms.setAdapter(minFilmAdapter);
        holder.vehiclePilots.setAdapter(minPersonAdapter);

        holder.vehicleFilms.setLayoutManager(new LinearLayoutManager(context));
        holder.vehiclePilots.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

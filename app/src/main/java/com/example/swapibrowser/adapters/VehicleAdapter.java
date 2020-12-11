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

        holder.vehicleName.setText(context.getString(R.string.name,  vehicle.getName()));
        holder.vehicleModel.setText(context.getString(R.string.model, vehicle.getModel()));
        holder.vehicleManufacturer.setText(context.getString(R.string.manufacturer, vehicle.getManufacturer()));
        holder.vehicleCost.setText(context.getString(R.string.cost, vehicle.getCostInCredits()));
        holder.vehicleLength.setText(context.getString(R.string.length, vehicle.getLength()));
        holder.vehicleMaxSpeed.setText(context.getString(R.string.max_speed, vehicle.getMaxAtmospheringSpeed()));
        holder.vehicleCrew.setText(context.getString(R.string.crew, vehicle.getCrew()));
        holder.vehiclePassengers.setText(context.getString(R.string.passengers, vehicle.getPassengers()));
        holder.vehicleCargo.setText(context.getString(R.string.cargo, vehicle.getCargoCapacity()));
        holder.vehicleConsumables.setText(context.getString(R.string.consumables, vehicle.getConsumables()));
        holder.vehicleClass.setText(context.getString(R.string.s_class, vehicle.getVehicleClass()));
        holder.vehicleEdited.setText(context.getString(R.string.edited, vehicle.getEdited()));
        holder.vehicleCreated.setText(context.getString(R.string.created, vehicle.getCreated()));

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

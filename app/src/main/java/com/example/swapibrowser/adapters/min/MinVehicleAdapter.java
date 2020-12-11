package com.example.swapibrowser.adapters.min;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.VehiclesGenerator;
import com.example.swapibrowser.holders.VehicleHolder;
import com.example.swapibrowser.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinVehicleAdapter extends RecyclerView.Adapter<VehicleHolder> {

    List<String> list = Collections.emptyList();
    Context context;
    VehiclesGenerator vehiclesGenerator = new VehiclesGenerator();
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public MinVehicleAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        getVehicles(list);
    }

    @NonNull
    @Override
    public VehicleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_recycler_layout_min, parent, false);
        return new VehicleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleHolder holder, int position) {
        if(!vehicles.isEmpty()) {
            holder.vehicleNameMin.setText(vehicles.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    public void getVehicles(List<String> list){

        ApiResponseListener<Vehicle> vehicleListener = new ApiResponseListener<Vehicle>() {
            @Override
            public void onResponseReceived(Vehicle response) {
                vehicles.add(response);
                notifyItemInserted(vehicles.size() - 1 );
            }
            @Override
            public void onError(Throwable error) {
                System.out.println(error.getMessage());
            }
        };

        for(String s: list) {
            vehiclesGenerator.getByFullUrl(s, vehicleListener);
        }
    }
}

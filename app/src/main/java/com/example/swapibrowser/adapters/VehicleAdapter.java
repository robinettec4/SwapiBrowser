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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_recycler_layout, parent, false);
        return new VehicleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleHolder holder, int position) {
        Vehicle vehicle = (Vehicle) list.get(position);
        holder.vehicleCardName.setText(context.getString(R.string.name,  vehicle.getName()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

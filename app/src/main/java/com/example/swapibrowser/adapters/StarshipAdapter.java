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
import com.example.swapibrowser.holders.StarshipHolder;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.starship.Starship;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StarshipAdapter  extends RecyclerView.Adapter<StarshipHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;

    public StarshipAdapter(List<ISingleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StarshipHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.starship_field_layout, parent, false);
        return new StarshipHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipHolder holder, int position) {

        Starship starship = (Starship) list.get(position);

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(starship.getFilms(), context);
        MinPersonAdapter minPersonAdapter = new MinPersonAdapter(starship.getPilots(), context);

        holder.starshipName.setText(context.getString(R.string.name,  starship.getName()));
        holder.starshipModel.setText(context.getString(R.string.model, starship.getModel()));
        holder.starshipManufacturer.setText(context.getString(R.string.manufacturer, starship.getManufacturer()));
        holder.starshipCost.setText(context.getString(R.string.cost, starship.getCostInCredits()));
        holder.starshipLength.setText(context.getString(R.string.length, starship.getLength()));
        holder.starshipMaxSpeed.setText(context.getString(R.string.max_speed, starship.getMaxAtmospheringSpeed()));
        holder.starshipCrew.setText(context.getString(R.string.crew, starship.getCrew()));
        holder.starshipPassengers.setText(context.getString(R.string.passengers, starship.getPassengers()));
        holder.starshipCargo.setText(context.getString(R.string.cargo, starship.getCargoCapacity()));
        holder.starshipConsumables.setText(context.getString(R.string.consumables, starship.getConsumables()));
        holder.starshipHyperDriveRating.setText(context.getString(R.string.starship_hyper_drive_rating, starship.getHyperdriveRating()));
        holder.starshipMGLT.setText(context.getString(R.string.starship_mglt, starship.getMGLT()));
        holder.starshipClass.setText(context.getString(R.string.s_class, starship.getStarshipClass()));
        holder.starshipEdited.setText(context.getString(R.string.edited, starship.getEdited()));
        holder.starshipCreated.setText(context.getString(R.string.created, starship.getCreated()));

        holder.starshipFilms.setAdapter(minFilmAdapter);
        holder.starshipPilots.setAdapter(minPersonAdapter);

        holder.starshipFilms.setLayoutManager(new LinearLayoutManager(context));
        holder.starshipPilots.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

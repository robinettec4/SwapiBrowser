package com.example.swapibrowser.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.activities.factory.ActivityFactory;
import com.example.swapibrowser.holders.PlanetHolder;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.planet.Planet;

import java.util.Collections;
import java.util.List;

public class PlanetAdapter  extends RecyclerView.Adapter<PlanetHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;
    ActivityFactory activityFactory = new ActivityFactory();

    public PlanetAdapter(List<ISingleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_recycler_layout, parent, false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {
        final Planet planet = (Planet) list.get(position);
        holder.planetCardName.setText(context.getString(R.string.name, planet.getName()));

        holder.planetCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activityFactory.CreateActivity("planets"));
                intent.putExtra("planets", planet);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

package com.example.swapibrowser.adapters.min;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.StarshipsGenerator;
import com.example.swapibrowser.holders.StarshipHolder;
import com.example.swapibrowser.models.starship.Starship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStarshipAdapter extends RecyclerView.Adapter<StarshipHolder> {

    List<String> list = Collections.emptyList();
    Context context;
    StarshipsGenerator starshipsGenerator = new StarshipsGenerator();
    ArrayList<Starship> starships = new ArrayList<>();

    public MinStarshipAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        getStarships(list);
    }

    @NonNull
    @Override
    public StarshipHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.starship_recycler_layout_min, parent, false);
        return new StarshipHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipHolder holder, int position) {
        if(!starships.isEmpty()) {
            holder.starshipNameMin.setText(starships.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return starships.size();
    }

    public void getStarships(List<String> list){

        ApiResponseListener<Starship> starshipListener = new ApiResponseListener<Starship>() {
            @Override
            public void onResponseReceived(Starship response) {
                starships.add(response);
                notifyItemInserted(starships.size() - 1);
            }
            @Override
            public void onError(Throwable error) {
                System.out.println(error.getMessage());
            }
        };

        for(String s: list) {
            starshipsGenerator.getByFullUrl(s, starshipListener);
        }
    }
}

package com.example.swapibrowser.adapters.min;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.SpeciesGenerator;
import com.example.swapibrowser.holders.SpeciesResultHolder;
import com.example.swapibrowser.models.species.SpeciesResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinSpeciesResultAdapter extends RecyclerView.Adapter<SpeciesResultHolder> {

    List<String> list = Collections.emptyList();
    Context context;
    SpeciesGenerator speciesGenerator = new SpeciesGenerator();
    ArrayList<SpeciesResult> speciesResults = new ArrayList<>();

    public MinSpeciesResultAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        getSpecies(list);
    }

    @NonNull
    @Override
    public SpeciesResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.species_field_layout_min, parent, false);
        return new SpeciesResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesResultHolder holder, int position) {
        if(!speciesResults.isEmpty()) {
            holder.speciesNameMin.setText(speciesResults.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return speciesResults.size();
    }

    public void getSpecies(List<String> list) {

        ApiResponseListener<SpeciesResult> speciesListener = new ApiResponseListener<SpeciesResult>() {
            @Override
            public void onResponseReceived(SpeciesResult response) {
                speciesResults.add(response);
                notifyItemInserted(speciesResults.size() - 1);
            }
            @Override
            public void onError(Throwable error) {
                System.out.println(error.getMessage());
            }
        };

        for(String s: list) {
            speciesGenerator.getByFullUrl(s, speciesListener);
        }
    }
}

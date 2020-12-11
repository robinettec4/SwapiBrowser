package com.example.swapibrowser.adapters.factory;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.adapters.FilmAdapter;
import com.example.swapibrowser.adapters.PersonAdapter;
import com.example.swapibrowser.adapters.PlanetAdapter;
import com.example.swapibrowser.adapters.SpeciesResultAdapter;
import com.example.swapibrowser.adapters.StarshipAdapter;
import com.example.swapibrowser.adapters.VehicleAdapter;
import com.example.swapibrowser.models.ISingleModel;

import java.util.List;

public class AdapterFactory implements IAdapterFactory {
    @Override
    public RecyclerView.Adapter CreateAdapter(String itemType, List<ISingleModel> list, Context context) {
        if(itemType.equals("films")){
            return new FilmAdapter(list, context);
        }
        if(itemType.equals("people")){
            return new PersonAdapter(list, context);
        }
        if(itemType.equals("planets")){
            return new PlanetAdapter(list, context);
        }
        if(itemType.equals("species")){
            return new SpeciesResultAdapter(list, context);
        }
        if(itemType.equals("starships")){
            return new StarshipAdapter(list, context);
        }
        if(itemType.equals("vehicles")){
            return new VehicleAdapter(list, context);
        } else {
            throw new UnknownError("Unknown Adapter Type");
        }
    }
}

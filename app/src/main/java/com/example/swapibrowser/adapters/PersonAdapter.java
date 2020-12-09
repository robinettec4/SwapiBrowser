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
import com.example.swapibrowser.adapters.min.MinSpeciesResultAdapter;
import com.example.swapibrowser.adapters.min.MinStarshipAdapter;
import com.example.swapibrowser.adapters.min.MinVehicleAdapter;
import com.example.swapibrowser.holders.PersonHolder;
import com.example.swapibrowser.models.person.Person;

import java.util.Collections;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonHolder> {

    List<Person> list = Collections.emptyList();
    Context context;

    public PersonAdapter(List<Person> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_field_layout, parent, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {

        Person person = list.get(position);

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(person.getFilms(), context);
        MinSpeciesResultAdapter minSpeciesResultAdapter = new MinSpeciesResultAdapter(person.getSpecies(), context);
        MinVehicleAdapter minVehicleAdapter = new MinVehicleAdapter(person.getVehicles(), context);
        MinStarshipAdapter minStarshipAdapter = new MinStarshipAdapter(person.getStarships(), context);

        holder.personName.setText(person.getName());
        holder.personHeight.setText(person.getHeight());
        holder.personMass.setText(person.getMass());
        holder.personHairColor.setText(person.getHairColor());
        holder.personSkinColor.setText(person.getSkinColor());
        holder.personEyeColor.setText(person.getEyeColor());
        holder.personBirthYear.setText(person.getBirthYear());
        holder.personGender.setText(person.getGender());
        holder.personHomeWorld.setText(person.getHomeworld());
        holder.personCreated.setText(person.getCreated());
        holder.personEdited.setText(person.getEdited());

        holder.personFilms.setAdapter(minFilmAdapter);
        holder.personSpecies.setAdapter(minSpeciesResultAdapter);
        holder.personVehicles.setAdapter(minVehicleAdapter);
        holder.personStarships.setAdapter(minStarshipAdapter);

        holder.personFilms.setLayoutManager(new LinearLayoutManager(context));
        holder.personSpecies.setLayoutManager(new LinearLayoutManager(context));
        holder.personVehicles.setLayoutManager(new LinearLayoutManager(context));
        holder.personStarships.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

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
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.person.Person;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;

    public PersonAdapter(List<ISingleModel> list, Context context) {
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

        Person person = (Person) list.get(position);

        MinFilmAdapter minFilmAdapter = new MinFilmAdapter(person.getFilms(), context);
        MinSpeciesResultAdapter minSpeciesResultAdapter = new MinSpeciesResultAdapter(person.getSpecies(), context);
        MinVehicleAdapter minVehicleAdapter = new MinVehicleAdapter(person.getVehicles(), context);
        MinStarshipAdapter minStarshipAdapter = new MinStarshipAdapter(person.getStarships(), context);

        holder.personName.setText(context.getString(R.string.name, person.getName()));
        holder.personHeight.setText(context.getString(R.string.person_height, person.getHeight()));
        holder.personMass.setText(context.getString(R.string.person_mass, person.getMass()));
        holder.personHairColor.setText(context.getString(R.string.person_hair_color, person.getHairColor()));
        holder.personSkinColor.setText(context.getString(R.string.person_skin_color, person.getSkinColor()));
        holder.personEyeColor.setText(context.getString(R.string.person_eye_color, person.getEyeColor()));
        holder.personBirthYear.setText(context.getString(R.string.person_birth_year, person.getBirthYear()));
        holder.personGender.setText(context.getString(R.string.person_gender, person.getGender()));
        holder.personHomeWorld.setText(context.getString(R.string.homeworld, person.getHomeworld()));
        holder.personCreated.setText(context.getString(R.string.created, person.getCreated()));
        holder.personEdited.setText(context.getString(R.string.edited, person.getEdited()));

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

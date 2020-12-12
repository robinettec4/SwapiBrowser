package com.example.swapibrowser.activities.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.ItemAdapterMin;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.utils.PageSaver;

public class ViewPerson extends AppCompatActivity {

    Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_field_layout);

        TextView personName = findViewById(R.id.person_name);
        TextView personHeight = findViewById(R.id.person_height);
        TextView personMass = findViewById(R.id.person_mass);
        TextView personHairColor = findViewById(R.id.person_hair_color);
        TextView personSkinColor = findViewById(R.id.person_skin_color);
        TextView personEyeColor = findViewById(R.id.person_eye_color);
        TextView personBirthYear = findViewById(R.id.person_birth_year);
        TextView personGender = findViewById(R.id.person_gender);
        TextView personHomeWorld = findViewById(R.id.person_homeworld);
        TextView  personCreated = findViewById(R.id.person_created);
        TextView personEdited = findViewById(R.id.person_edited);

        RecyclerView personFilms = findViewById(R.id.person_films_recycler);
        RecyclerView personSpecies = findViewById(R.id.person_species_recycler);
        RecyclerView personVehicles = findViewById(R.id.person_vehicles_recycler);
        RecyclerView personStarships = findViewById(R.id.person_starships_recycler);

        favorite = findViewById(R.id.favorite);
        checkButton();

        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("people");

        ItemAdapterMin minFilmAdapter = new ItemAdapterMin(person.getFilms(), ViewPerson.this, "films");
        ItemAdapterMin minSpeciesResultAdapter = new ItemAdapterMin(person.getSpecies(), ViewPerson.this, "species");
        ItemAdapterMin minVehicleAdapter = new ItemAdapterMin(person.getVehicles(), ViewPerson.this, "vehicles");
        ItemAdapterMin minStarshipAdapter = new ItemAdapterMin(person.getStarships(), ViewPerson.this, "starships");

        personName.setText(getString(R.string.name, person.getName()));
        personHeight.setText(getString(R.string.person_height, person.getHeight()));
        personMass.setText(getString(R.string.person_mass, person.getMass()));
        personHairColor.setText(getString(R.string.person_hair_color, person.getHairColor()));
        personSkinColor.setText(getString(R.string.person_skin_color, person.getSkinColor()));
        personEyeColor.setText(getString(R.string.person_eye_color, person.getEyeColor()));
        personBirthYear.setText(getString(R.string.person_birth_year, person.getBirthYear()));
        personGender.setText(getString(R.string.person_gender, person.getGender()));
        setHomeworld(person.getHomeworld(), personHomeWorld);
        personCreated.setText(getString(R.string.created, person.getCreated()));
        personEdited.setText(getString(R.string.edited, person.getEdited()));

        personFilms.setAdapter(minFilmAdapter);
        personSpecies.setAdapter(minSpeciesResultAdapter);
        personVehicles.setAdapter(minVehicleAdapter);
        personStarships.setAdapter(minStarshipAdapter);

        personFilms.setLayoutManager(new LinearLayoutManager(ViewPerson.this));
        personSpecies.setLayoutManager(new LinearLayoutManager(ViewPerson.this));
        personVehicles.setLayoutManager(new LinearLayoutManager(ViewPerson.this));
        personStarships.setLayoutManager(new LinearLayoutManager(ViewPerson.this));
    }

    private void setHomeworld(String url, final TextView homeworld){

        IGenerator generator = new GeneratorFactory().CreateGenerator("planets");

        final ApiResponseListener<ISingleModel> listener = new ApiResponseListener<ISingleModel>() {
            @Override
            public void onResponseReceived(ISingleModel response) {
                homeworld.setText(getString(R.string.homeworld, response.getName()));
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        generator.getByFullUrl(url, listener);
    }

    public void editFavorite(View view) {
        PageSaver saver = new PageSaver();
        if (favorite.getText().toString().equals(getString(R.string.favorite))) {
            favorite.setText(R.string.unfavorite);
            saver.saveFavorite(this);
        }
        else {
            favorite.setText(R.string.favorite);
            saver.removeFavorite(this);
        }
    }

    public void checkButton(){
        PageSaver saver = new PageSaver();
        if (!saver.check(saver.read(this), this)) {
            favorite.setText(R.string.unfavorite);
        }
        else {
            favorite.setText(R.string.favorite);
        }
    }
}

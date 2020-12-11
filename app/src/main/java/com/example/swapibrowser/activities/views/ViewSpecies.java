package com.example.swapibrowser.activities.views;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.swapibrowser.models.species.SpeciesResult;

public class ViewSpecies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.species_field_layout);

         TextView speciesName = findViewById(R.id.species_name);
         TextView speciesClassification = findViewById(R.id.species_classification);
         TextView speciesDesignation = findViewById(R.id.species_designation);
         TextView speciesAvgHeight = findViewById(R.id.species_avg_height);
         TextView speciesAvgLifespan = findViewById(R.id.species_avg_lifespan);
         TextView speciesSkinColors = findViewById(R.id.species_skin_colors);
         TextView speciesHairColors = findViewById(R.id.species_hair_colors);
         TextView speciesEyeColors = findViewById(R.id.species_eye_colors);
         TextView speciesHomeworld = findViewById(R.id.species_homeworld);
         TextView speciesLanguage = findViewById(R.id.species_language);
         TextView speciesEdited = findViewById(R.id.species_edited);
         TextView speciesCreated = findViewById(R.id.species_created);

         RecyclerView speciesPeople = findViewById(R.id.species_people_recycler);
         RecyclerView speciesFilms = findViewById(R.id.species_films_recycler);

        Intent intent = getIntent();
        SpeciesResult speciesResult = (SpeciesResult) intent.getSerializableExtra("species");

        ItemAdapterMin minFilmAdapter = new ItemAdapterMin(speciesResult.getFilms(), ViewSpecies.this, "films");
        ItemAdapterMin minPersonAdapter = new ItemAdapterMin(speciesResult.getPeople(), ViewSpecies.this, "people");

        speciesName.setText(getString(R.string.name, speciesResult.getName()));
        speciesClassification.setText(getString(R.string.s_class, speciesResult.getClassification()));
        speciesDesignation.setText(getString(R.string.species_designation, speciesResult.getDesignation()));
        speciesAvgHeight.setText(getString(R.string.species_average_height, speciesResult.getAverageHeight()));
        speciesSkinColors.setText(getString(R.string.species_skin_colors, speciesResult.getSkinColors()));
        speciesHairColors.setText(getString(R.string.species_hair_colors, speciesResult.getHairColors()));
        speciesEyeColors.setText(getString(R.string.species_eye_colors, speciesResult.getEyeColors()));
        speciesAvgLifespan.setText(getString(R.string.species_average_lifespan, speciesResult.getAverageLifespan()));
        setHomeworld(speciesResult.getHomeworld(), speciesHomeworld);
        speciesLanguage.setText(getString(R.string.species_language, speciesResult.getLanguage()));
        speciesEdited.setText(getString(R.string.edited, speciesResult.getEdited()));
        speciesCreated.setText(getString(R.string.created, speciesResult.getCreated()));

        speciesFilms.setAdapter(minFilmAdapter);
        speciesPeople.setAdapter(minPersonAdapter);

        speciesFilms.setLayoutManager(new LinearLayoutManager(ViewSpecies.this));
        speciesPeople.setLayoutManager(new LinearLayoutManager(ViewSpecies.this));
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

            }
        };
        generator.getByFullUrl(url, listener);
    }
}

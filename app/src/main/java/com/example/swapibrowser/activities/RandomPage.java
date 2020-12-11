package com.example.swapibrowser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.ItemAdapter;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.factory.SearcherFactory;
import com.example.swapibrowser.utils.PageSaver;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class RandomPage extends AppCompatActivity {
    RecyclerView randomRecycler;
    PageSaver saver = new PageSaver();
    int field;
    String[] list = new String[]{"people", "films", "planets", "species", "starships", "vehicles"};
    GeneratorFactory generatorFactory = new GeneratorFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_page);
    }

    private void loadItemData(final String itemType, Integer entry) {
        final IGenerator generator = generatorFactory.CreateGenerator(itemType);
        final ArrayList<ISingleModel> items = new ArrayList<>();

        final ApiResponseListener<ISingleModel> listener = new ApiResponseListener<ISingleModel>() {
            @Override
            public void onResponseReceived(ISingleModel response) {
                if (response!=null) {
                    items.add(response);
                    saver.save(RandomPage.this, response.getUrl(), itemType);
                    randomRecycler.setAdapter(new ItemAdapter(items, RandomPage.this, itemType.toLowerCase()));
                    randomRecycler.setAdapter(new ItemAdapter(items, RandomPage.this, itemType.toLowerCase()));
                    randomRecycler.setLayoutManager(new LinearLayoutManager(RandomPage.this));
                } else {
                    Snackbar.make(findViewById(R.id.random_recycler), "Null response received", Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        generator.getById(String.valueOf(entry), listener);
    }

    public void getItemCount(final String itemType){
        final ISearcher searcher = new SearcherFactory().CreateSearcher(itemType);

        final ApiResponseListener<IModel> bigListener = new ApiResponseListener<IModel>() {
            @Override
            public void onResponseReceived(IModel response) {
                Integer entry = new Random().nextInt(response.getCount() - 1) + 1;
                loadItemData(itemType, entry);
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        searcher.getAll(bigListener);
    }

    public void reload(View view){
        randomRecycler = findViewById(R.id.random_recycler);
        randomRecycler.setLayoutManager(null);
        randomRecycler.setAdapter(null);
        field = new Random().nextInt(6);
        getItemCount(list[field]);
    }

    public void saveFavorite(String url, String itemType){ saver.saveFavorite(this, url, itemType); }
}

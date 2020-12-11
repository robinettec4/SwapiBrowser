package com.example.swapibrowser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.activities.factory.ActivityFactory;
import com.example.swapibrowser.adapters.factory.AdapterFactory;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.factory.SearcherFactory;
import com.example.swapibrowser.utils.CustomRVItemTouchListener;
import com.example.swapibrowser.utils.RecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecentlyUpdated extends AppCompatActivity {

    RecyclerView recentlyUpdatedRecycler;
    GeneratorFactory generatorFactory = new GeneratorFactory();
    SearcherFactory searcherFactory = new SearcherFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recently_updated);
        recentlyUpdatedRecycler = findViewById(R.id.recently_updated_recycler);
        final Spinner recentlyUpdatedSpinner = findViewById(R.id.recently_updated_spinner);

        recentlyUpdatedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getMostRecentItem(recentlyUpdatedSpinner.getSelectedItem().toString().toLowerCase());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void getMostRecentItem(final String itemType){
        ISearcher searcher = searcherFactory.CreateSearcher(itemType);
        final ArrayList<ISingleModel> items = new ArrayList<>();
        ApiResponseListener<IModel> listener = new ApiResponseListener<IModel>() {
            @Override
            public void onResponseReceived(IModel response) {
                items.addAll(response.getResults());
                recentlyUpdatedRecycler.setAdapter(new AdapterFactory().CreateAdapter(itemType.toLowerCase(), items, RecentlyUpdated.this));
                recentlyUpdatedRecycler.setLayoutManager(new LinearLayoutManager(RecentlyUpdated.this));
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        searcher.getByOrdering("edited", listener);
    }
}
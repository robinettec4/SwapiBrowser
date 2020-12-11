package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.ItemAdapter;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.factory.SearcherFactory;

import java.util.ArrayList;

public class RecentlyCreated extends AppCompatActivity {
    RecyclerView recentlyCreatedRecycler;
    SearcherFactory searcherFactory = new SearcherFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recently_created);
        recentlyCreatedRecycler = findViewById(R.id.recently_created_recycler);
        final Spinner recentlyCreatedSpinner = findViewById(R.id.recently_created_spinner);

        recentlyCreatedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getMostRecentItem(recentlyCreatedSpinner.getSelectedItem().toString().toLowerCase());
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
                recentlyCreatedRecycler.setAdapter(new ItemAdapter(items, RecentlyCreated.this, itemType.toLowerCase()));
                recentlyCreatedRecycler.setLayoutManager(new LinearLayoutManager(RecentlyCreated.this));
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        searcher.getByOrdering("created", listener);
    }
}

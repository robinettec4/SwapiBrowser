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
import com.example.swapibrowser.adapters.factory.AdapterFactory;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.factory.SearcherFactory;

import java.util.ArrayList;

public class RecentlyCreated extends AppCompatActivity {
    RecyclerView recentlyCreatedRecycler;
    GeneratorFactory generatorFactory = new GeneratorFactory();
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

    public void loadRecentItemData(ISingleModel item, final String itemType){

        final ArrayList<ISingleModel> items = new ArrayList<>();
        IGenerator generator = generatorFactory.CreateGenerator(itemType.toLowerCase());
        final ApiResponseListener<ISingleModel> listener = new ApiResponseListener<ISingleModel>() {

            @Override
            public void onResponseReceived(ISingleModel response) {
                items.add(response);
                recentlyCreatedRecycler.setAdapter(new AdapterFactory().CreateAdapter(itemType.toLowerCase(), items, RecentlyCreated.this));
                recentlyCreatedRecycler.setLayoutManager(new LinearLayoutManager(RecentlyCreated.this));
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        generator.getByFullUrl(item.getUrl(), listener);
    }

    public void getMostRecentItem(final String itemType){

        ISearcher searcher = searcherFactory.CreateSearcher(itemType);
        ApiResponseListener<IModel> listener = new ApiResponseListener<IModel>() {
            @Override
            public void onResponseReceived(IModel response) {
                loadRecentItemData((ISingleModel) response.getResults().get(0), itemType);
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        searcher.getByOrdering("created", listener);
    }
}

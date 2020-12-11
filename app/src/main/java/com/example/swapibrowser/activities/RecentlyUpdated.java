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

public class RecentlyUpdated extends AppCompatActivity {

    RecyclerView recentlyUpdatedRecycler;
    GeneratorFactory generatorFactory = new GeneratorFactory();
    SearcherFactory searcherFactory = new SearcherFactory();
    ActivityFactory activityFactory = new ActivityFactory();

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

    public void loadRecentItemData(ISingleModel item, final String itemType){

        final ArrayList<ISingleModel> items = new ArrayList<>();
        IGenerator generator = generatorFactory.CreateGenerator(itemType.toLowerCase());
        final ApiResponseListener<ISingleModel> listener = new ApiResponseListener<ISingleModel>() {

            @Override
            public void onResponseReceived(final ISingleModel response) {
                items.add(response);
                recentlyUpdatedRecycler.setAdapter(new AdapterFactory().CreateAdapter(itemType.toLowerCase(), items, RecentlyUpdated.this));
                recentlyUpdatedRecycler.setLayoutManager(new LinearLayoutManager(RecentlyUpdated.this));

                recentlyUpdatedRecycler.setOnTouchListener((View.OnTouchListener) new CustomRVItemTouchListener(RecentlyUpdated.this, recentlyUpdatedRecycler, new RecyclerViewItemClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent = new Intent(RecentlyUpdated.this, activityFactory.CreateActivity(itemType));
                        intent.putExtra(itemType, response);
                        startActivity(intent);
                        recentlyUpdatedRecycler.setOnClickListener(null);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

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
        searcher.getByOrdering("edited", listener);
    }
}
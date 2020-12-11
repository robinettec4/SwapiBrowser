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
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.factory.SearcherFactory;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class RecentPage extends AppCompatActivity {

    RecyclerView recentlyUpdatedRecycler;
    SearcherFactory searcherFactory = new SearcherFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        recentlyUpdatedRecycler = findViewById(R.id.recent_recycler);
        final Spinner topicSpinner = findViewById(R.id.topic_spinner);
        final Spinner typeSpinner = findViewById(R.id.type_spinner);

        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getMostRecentItem(topicSpinner.getSelectedItem().toString().toLowerCase(), typeSpinner.getSelectedItem().toString().toLowerCase());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        topicSpinner.setOnItemSelectedListener(listener);
        typeSpinner.setOnItemSelectedListener(listener);

        TabLayout tabs = findViewById(R.id.menu_tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { new TabsHelper(tab.getPosition(), RecentPage.this); }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { new TabsHelper(tab.getPosition(), RecentPage.this); }
        });
    }

    public void getMostRecentItem(final String itemType, final String field){
        ISearcher searcher = searcherFactory.CreateSearcher(itemType);
        final ArrayList<ISingleModel> items = new ArrayList<>();
        ApiResponseListener<IModel> listener = new ApiResponseListener<IModel>() {
            @Override
            public void onResponseReceived(IModel response) {
                items.addAll(response.getResults());
                recentlyUpdatedRecycler.setAdapter(new ItemAdapter(items, RecentPage.this, itemType.toLowerCase()));
                recentlyUpdatedRecycler.setLayoutManager(new LinearLayoutManager(RecentPage.this));
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        searcher.getByOrdering(field, listener);
    }
}
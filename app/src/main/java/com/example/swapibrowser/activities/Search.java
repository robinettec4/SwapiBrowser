package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
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
import com.example.swapibrowser.utils.PageSaver;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;


public class Search extends AppCompatActivity {

    RecyclerView searchRecycler;
    EditText inputText;
    private String field;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchRecycler = findViewById(R.id.search_recycler);
        inputText = findViewById(R.id.input);

        final Spinner recentlyUpdatedSpinner = findViewById(R.id.search_spinner);

        recentlyUpdatedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                field = recentlyUpdatedSpinner.getSelectedItem().toString().toLowerCase();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        TabLayout tabs = findViewById(R.id.menu_tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { new TabsHelper(tab.getPosition(), Search.this); }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { new TabsHelper(tab.getPosition(), Search.this); }
        });
    }

    public void search(View view){
        input = inputText.getText().toString().toLowerCase();
        searchItems(field);
    }

    private void searchItems(final String itemType) {
        searchRecycler.setAdapter(null);
        searchRecycler.setLayoutManager(null);
        final ISearcher searcher = new SearcherFactory().CreateSearcher(itemType);
        final ArrayList<ISingleModel> items = new ArrayList<>();
        final ApiResponseListener<IModel> listener = new ApiResponseListener<IModel>() {
            @Override
            public void onResponseReceived(IModel response) {
                if (response != null) {
                    items.addAll(response.getResults());
                    searchRecycler.setAdapter(new ItemAdapter(items, Search.this, itemType.toLowerCase()));
                    searchRecycler.setLayoutManager(new LinearLayoutManager(Search.this));
                }
                else{
                    Log.e("ResponseError","Null Response");
                }
            }

            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };
        searcher.getBySearch(input, listener);
    }

}

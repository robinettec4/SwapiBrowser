package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.factory.AdapterFactory;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.factory.SearcherFactory;
import com.example.swapibrowser.utils.PageSaver;


import java.util.ArrayList;


public class Search extends AppCompatActivity {

    RecyclerView searchRecycler;
    EditText inputText;
    private String field;
    private String input;
    PageSaver saver = new PageSaver();

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
    }

    public void search(View view){
        Log.d("progress", "onClick");
        input = inputText.getText().toString().toLowerCase();
        searchItems(field);
    }

    private void searchItems(final String itemType) {
        Log.d("progress", "searchItems");
        final ISearcher searcher = new SearcherFactory().CreateSearcher(itemType);
        final ArrayList<ISingleModel> items = new ArrayList<>();
        final ApiResponseListener<IModel> listener = new ApiResponseListener<IModel>() {
            @Override
            public void onResponseReceived(IModel response) {
                Log.d("progress", "onResponseReceived");
                if (response != null) {
                    items.add((ISingleModel) response.getResults().get(0));
                    save(items.get(0).getUrl(), itemType);
                    searchRecycler.setAdapter(new AdapterFactory().CreateAdapter(itemType.toLowerCase(), items, Search.this));
                    searchRecycler.setLayoutManager(new LinearLayoutManager(Search.this));
                }
                else{
                    Log.d("response", "no response");
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        Log.d("progress", "getBySearch");
        searcher.getBySearch(input, listener);
    }

    public void save(String url, String itemType){
        saver.save(this, url, itemType);
    }

    public void saveFavorite(String url, String itemType){ saver.saveFavorite(this, url, itemType); }
}

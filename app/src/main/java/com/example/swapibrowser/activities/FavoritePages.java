package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.factory.AdapterFactory;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.factory.SearcherFactory;
import com.example.swapibrowser.utils.PageSaver;

import java.util.ArrayList;

public class FavoritePages extends AppCompatActivity {

    private RecyclerView recView;
    private ArrayList<String> favorites;
    AdapterFactory factory = new AdapterFactory();
    PageSaver saver = new PageSaver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recView = findViewById(R.id.favRecView);
        recView.setLayoutManager(new LinearLayoutManager(this));

        favorites = saver.readFavorite(this);

        initialize();

    }

    public void initialize(){
        for (String s : favorites){
            String[] split = s.split(" :");
            getResults(split);
        }
    }

    public void getResults(String[] data){
        final String itemType = data[1];
        String url = data[0];
        final IGenerator generator = new GeneratorFactory().CreateGenerator(itemType);
        final ArrayList<ISingleModel> items = new ArrayList<>();
        final ApiResponseListener<ISingleModel> listener = new ApiResponseListener<ISingleModel>() {
            @Override
            public void onResponseReceived(ISingleModel response) {
                Log.d("progress", "onResponseReceived");
                if (response != null) {
                    items.add(response);
                    save(items.get(0).getUrl(), itemType);
                    recView.setAdapter(new AdapterFactory().CreateAdapter(itemType.toLowerCase(), items, FavoritePages.this));
                    recView.setLayoutManager(new LinearLayoutManager(FavoritePages.this));
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
        generator.getByFullUrl(url, listener);
    }

    public void save(String url, String itemType){ saver.save(this, url, itemType); }
}

package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.ItemAdapter;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.utils.PageSaver;

import java.util.ArrayList;

public class LastVisited extends AppCompatActivity {

    PageSaver saver = new PageSaver();
    RecyclerView recentlyViewedRecycler;
    Button favoriteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_visited);
        recentlyViewedRecycler = findViewById(R.id.recently_viewed_recycler);
        favoriteButton = findViewById(R.id.favorite);

        String recent = saver.read(this);

        String[] data = recent.split(" :");
        searchItems(data[1], data[0]);

    }

    private void searchItems(final String itemType, String url) {
        Log.d("progress", url);
        final IGenerator generator = new GeneratorFactory().CreateGenerator(itemType);
        final ArrayList<ISingleModel> items = new ArrayList<>();
        final ApiResponseListener<ISingleModel> listener = new ApiResponseListener<ISingleModel>() {
            @Override
            public void onResponseReceived(ISingleModel response) {
                Log.d("progress", "onResponseReceived");
                if (response != null) {
                    items.add(response);
                    recentlyViewedRecycler.setAdapter(new ItemAdapter(items, LastVisited.this, itemType.toLowerCase()));
                    recentlyViewedRecycler.setLayoutManager(new LinearLayoutManager(LastVisited.this));
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

    public void save(String url, String itemType){
        saver.save(this, url, itemType);
    }
}

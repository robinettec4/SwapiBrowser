package com.example.swapibrowser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.AdapterFactory;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.GeneratorFactory;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.SearcherFactory;
import com.example.swapibrowser.utils.PageSaver;

import java.util.ArrayList;
import java.util.Random;

public class RandomPage extends AppCompatActivity {
    RecyclerView randomRecycler;
    PageSaver saver = new PageSaver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_page);
        randomRecycler = findViewById(R.id.recently_updated_recycler);
        int field = decideField();
        String[] list = new String[]{"people", "films", "planets", "species", "starships", "vehicles"};
        getItemCount(list[field]);
    }

    public int decideField(){
        Random ran = new Random();
        int field = ran.nextInt(6);
        return field;
    }

    private void loadItemData(final String itemType, Integer entry) {
        final IGenerator generator = new GeneratorFactory().CreateGenerator(itemType);
        final ArrayList<ISingleModel> items = new ArrayList<>();

        final ApiResponseListener<ISingleModel> listener = new ApiResponseListener<ISingleModel>() {
            @Override
            public void onResponseReceived(ISingleModel response) {
                if (response!=null) {
                    items.add(response);
                    save(items.get(0).getUrl(), itemType);
                    randomRecycler.setAdapter(new AdapterFactory().CreateAdapter(itemType.toLowerCase(), items, RandomPage.this));
                    randomRecycler.setLayoutManager(new LinearLayoutManager(RandomPage.this));
                }
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        generator.getById(String.valueOf(entry), listener);
    }

    public void getItemCount(final String itemType){
        final ISearcher searcher = new SearcherFactory().CreateSearcher(itemType);

        final ApiResponseListener<IModel> bigListener = new ApiResponseListener<IModel>() {
            @Override
            public void onResponseReceived(IModel response) {
                Integer entries = response.getCount();
                Random random = new Random();
                Integer entry = random.nextInt(entries);
                loadItemData(itemType, entry);
            }

            @Override
            public void onError(Throwable error) {

            }
        };
        searcher.getAll(bigListener);
    }

    public void reload(View view){
        Intent intent = new Intent(this, RandomPage.class);
        finish();
        startActivity(intent);
    }

    public void save(String url, String itemType){
        saver.save(this, url, itemType);
    }
}

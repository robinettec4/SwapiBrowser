package com.example.swapibrowser.activities;

import android.content.ClipData;
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
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.generators.factory.IGeneratorFactory;
import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.utils.PageSaver;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FavoritePages extends AppCompatActivity {

    private RecyclerView recView;
    private ArrayList<String> favorites;
    PageSaver saver = new PageSaver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recView = findViewById(R.id.favorite_recycler);
        recView.setLayoutManager(new LinearLayoutManager(this));

        favorites = saver.readFavorite(this);

        final Spinner favoriteSpinner = findViewById(R.id.favorite_spinner);

        favoriteSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getMostRecentItem(favoriteSpinner.getSelectedItem().toString().toLowerCase());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        TabLayout tabs = findViewById(R.id.menu_tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { new TabsHelper(tab.getPosition(), FavoritePages.this); }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { new TabsHelper(tab.getPosition(), FavoritePages.this); }
        });
    }

        public void getMostRecentItem(final String itemType){

            ArrayList<String> url = sort(favorites, itemType);

            final IGenerator generator = new GeneratorFactory().CreateGenerator(itemType);
            final ArrayList<ISingleModel> items = new ArrayList<>();
            final ItemAdapter adapter = new ItemAdapter(items, FavoritePages.this, itemType.toLowerCase());
            final LinearLayoutManager manager = new LinearLayoutManager(FavoritePages.this);
            ApiResponseListener<ISingleModel> listener = new ApiResponseListener<ISingleModel>() {
                @Override
                public void onResponseReceived(ISingleModel response) {
                    if (response != null) {
                        items.add(response);
                        recView.setAdapter(adapter);
                        recView.setLayoutManager(manager);
                    } else {
                        Log.e("ResponseError", "Null Response");
                    }
                }
                @Override
                public void onError (Throwable error){
                    Log.e("ResponseError", error.getMessage());
                }
            };
            for(String s : url) {
                generator.getByFullUrl(s, listener);
            }
        }

    public ArrayList<String> sort(ArrayList<String> favorites, String itemType){
        ArrayList<String> url = new ArrayList<>();
        for(int i = 0; i < favorites.size(); i++){
            String[] temp = favorites.get(i).split(" :");
            if (temp[1].equals((itemType))){
                url.add(temp[0]);
            }
        }
        return url;
    }


    public void save(String url, String itemType){ saver.save(this, url, itemType); }
}

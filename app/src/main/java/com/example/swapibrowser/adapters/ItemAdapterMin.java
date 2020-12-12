package com.example.swapibrowser.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.generators.factory.GeneratorFactory;
import com.example.swapibrowser.holders.ItemHolder;
import com.example.swapibrowser.models.ISingleModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemAdapterMin extends RecyclerView.Adapter<ItemHolder> {

    List<String> list = Collections.emptyList();
    Context context;
    ArrayList<ISingleModel> items = new ArrayList<>();
    GeneratorFactory generatorFactory = new GeneratorFactory();
    String itemType;

    public ItemAdapterMin(List<String> list, Context context, String itemType) {
        this.list = list;
        this.context = context;
        this.itemType = itemType;
        getItem(list);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_layout_min, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        if(!items.isEmpty()) {
            holder.itemNameMin.setText(items.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void getItem(List<String> list){
        IGenerator generator = generatorFactory.CreateGenerator(itemType);
        ApiResponseListener<ISingleModel> itemListener = new ApiResponseListener<ISingleModel>() {
            @Override
            public void onResponseReceived(ISingleModel response) {
                items.add(response);
                notifyItemInserted(items.size() - 1);
            }
            @Override
            public void onError(Throwable error) {
                Log.e("ResponseError", error.getMessage());
            }
        };

        for(String s: list){
            generator.getByFullUrl(s, itemListener);
        }
    }
}

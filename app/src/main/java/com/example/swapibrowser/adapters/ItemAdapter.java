package com.example.swapibrowser.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.activities.factory.ActivityFactory;
import com.example.swapibrowser.holders.ItemHolder;
import com.example.swapibrowser.models.ISingleModel;

import java.util.Collections;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
    List<ISingleModel> list = Collections.emptyList();
    Context context;
    String itemType;

    public ItemAdapter(List<ISingleModel> list, Context context, String itemType) {
        this.list = list;
        this.context = context;
        this.itemType = itemType;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_layout, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final ActivityFactory activityFactory = new ActivityFactory();
        final ISingleModel item = list.get(position);
        holder.itemCardName.setText(context.getString(R.string.name, item.getName()));

        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activityFactory.CreateActivity(itemType));
                intent.putExtra(itemType, item);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

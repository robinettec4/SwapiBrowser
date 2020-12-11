package com.example.swapibrowser.adapters.factory;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.models.ISingleModel;

import java.util.List;

public interface IAdapterFactory {
    RecyclerView.Adapter CreateAdapter(String itemType, List<ISingleModel> list, Context context);
}

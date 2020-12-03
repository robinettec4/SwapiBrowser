package com.example.swapibrowser.api;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiResponse<ResponseType> implements Callback<ResponseType> {
    private WeakReference<ApiResponseListener<ResponseType>> listener;

    public ApiResponse(ApiResponseListener<ResponseType> listener){
        this.listener = new WeakReference<>(listener);
    }

    @Override
    public void onResponse(@NonNull Call<ResponseType> call, @NonNull Response<ResponseType> response) {
        if (listener != null && listener.get() != null){
            listener.get().onResponseReceived(response.body());
        }
    }

    @Override
    public void onFailure(@NonNull Call<ResponseType> call, @NonNull Throwable t) {
        if (listener != null && listener.get() != null){
            listener.get().onError();
        }
    }
}

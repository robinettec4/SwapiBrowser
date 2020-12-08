package com.example.swapibrowser.generators;

import android.util.Log;

import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.retrofit.RetroClient;

public class PeopleGenerator implements Generator<People>{
    private ApiService api = RetroClient.getApiService();

    @Override
    public void getById(String id, ApiResponseListener<People> listener) {
        api.getPeople("people/").enqueue(new ApiResponse<>(listener));
    }

    public void get(ApiResponseListener<People> listener){
        api.getPeople("people/").enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByFullUrl(String url, ApiResponseListener<People> listener) {
        api.getPeople(url).enqueue(new ApiResponse<>(listener));
    }
}

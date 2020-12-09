package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.starship.Starships;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class StarshipsSearcher implements ISearcher<Starships> {

    private ApiService api = RetroClient.getApiService();

    public void getBySearch(String searchText, ApiResponseListener<Starships> listener){
        api.getStarships("starships/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getByFullUrl(String url, ApiResponseListener<Starships> listener) {
        api.getStarships(url).enqueue(new ApiResponse<>(listener));
    }

    public void getById(String id, ApiResponseListener<Starships> listener){
        api.getStarships("starships/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getByPage(String searchText, ApiResponseListener<Starships> listener) {
        api.getStarships("starships/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAll(ApiResponseListener<Starships> listener) {
        api.getStarships("starships/").enqueue(new ApiResponse<>(listener));
    }
}
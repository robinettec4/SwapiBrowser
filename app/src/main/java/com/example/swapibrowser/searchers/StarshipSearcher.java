package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.starship.Starships;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class StarshipSearcher {

    private ApiService api = RetroClient.getApiService();

    public void getStarshipBySearch(String searchText, ApiResponseListener<Starships> listener){
        api.getStarships("starships/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getStarshipById(String id, ApiResponseListener<Starships> listener){
        api.getStarships("starships/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getStarshipsByPage(String searchText, ApiResponseListener<Starships> listener) {
        api.getStarships("starships/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAllStarships(ApiResponseListener<Starships> listener) {
        api.getStarships("starships/").enqueue(new ApiResponse<>(listener));
    }

    public void getAllStarshipsByPageHelper(String searchText, ApiResponseListener<Starships> listener) {
        api.getStarships(searchText).enqueue(new ApiResponse<>(listener));
    }
}
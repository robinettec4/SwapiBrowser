package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.planet.Planets;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class PlanetSearcher {

    private ApiService api = RetroClient.getApiService();

    public void getPlanetBySearch(String searchText, ApiResponseListener<Planets> listener){
        api.getPlanets("planets/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getPlanetById(String id, ApiResponseListener<Planets> listener){
        api.getPlanets("planets/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getPlanetsByPage(String searchText, ApiResponseListener<Planets> listener) {
        api.getPlanets("planets/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAllPlanets(ApiResponseListener<Planets> listener) {
        api.getPlanets("planets/").enqueue(new ApiResponse<>(listener));
    }

    public void getAllPlanetsByPageHelper(String searchText, ApiResponseListener<Planets> listener) {
        api.getPlanets(searchText).enqueue(new ApiResponse<>(listener));
    }
}
package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.planet.Planets;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class PlanetsSearcher implements ISearcher<Planets> {

    private final ApiService api = RetroClient.getApiService();

    public void getBySearch(String searchText, ApiResponseListener<Planets> listener){
        api.getPlanets("planets/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getByFullUrl(String url, ApiResponseListener<Planets> listener) {
        api.getPlanets(url).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByOrdering(String orderingField, ApiResponseListener<Planets> listener) {
        api.getPlanets("planets/?ordering=" + orderingField).enqueue(new ApiResponse<>(listener));
    }

    public void getById(String id, ApiResponseListener<Planets> listener){
        api.getPlanets("planets/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getByPage(String searchText, ApiResponseListener<Planets> listener) {
        api.getPlanets("planets/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAll(ApiResponseListener<Planets> listener) {
        api.getPlanets("planets/").enqueue(new ApiResponse<>(listener));
    }
}
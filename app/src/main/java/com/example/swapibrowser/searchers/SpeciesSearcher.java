package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.species.Species;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class SpeciesSearcher implements ISearcher<Species> {

    private final ApiService api = RetroClient.getApiService();

    public void getBySearch(String searchText, ApiResponseListener<Species> listener){
        api.getSpecies("species/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getById(String id, ApiResponseListener<Species> listener){
        api.getSpecies("species/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getByPage(String searchText, ApiResponseListener<Species> listener) {
        api.getSpecies("species/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getByFullUrl(String url, ApiResponseListener<Species> listener) {
        api.getSpecies(url).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByOrdering(String orderingField, ApiResponseListener<Species> listener) {
        api.getSpecies("species/?ordering=" + orderingField).enqueue(new ApiResponse<>(listener));
    }

    public void getAll(ApiResponseListener<Species> listener) {
        api.getSpecies("species/").enqueue(new ApiResponse<>(listener));
    }
}

package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.species.Species;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class SpeciesSearcher {

    private ApiService api = RetroClient.getApiService();

    public void getSpeciesResultBySearch(String searchText, ApiResponseListener<Species> listener){
        api.getSpecies("species/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getSpeciesResultById(String id, ApiResponseListener<Species> listener){
        api.getSpecies("species/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getSpeciesByPage(String searchText, ApiResponseListener<Species> listener) {
        api.getSpecies("species/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAllSpecies(ApiResponseListener<Species> listener) {
        api.getSpecies("species/").enqueue(new ApiResponse<>(listener));
    }

    public void getAllSpeciesByPageHelper(String searchText, ApiResponseListener<Species> listener) {
        api.getSpecies(searchText).enqueue(new ApiResponse<>(listener));
    }
}

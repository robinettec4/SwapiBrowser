package com.example.swapibrowser.generators;

import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.species.SpeciesResult;
import com.example.swapibrowser.retrofit.RetroClient;

public class SpeciesGenerator implements IGenerator<SpeciesResult> {

    private final ApiService api = RetroClient.getApiService();

    @Override
    public void getById(String id, ApiResponseListener<SpeciesResult> listener) {
        api.getSpeciesResult("species/" + id).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByFullUrl(String url, ApiResponseListener<SpeciesResult> listener) {
        api.getSpeciesResult(url).enqueue(new ApiResponse<>(listener));
    }
}

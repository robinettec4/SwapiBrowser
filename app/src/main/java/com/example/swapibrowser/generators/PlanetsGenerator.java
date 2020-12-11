package com.example.swapibrowser.generators;

import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.planet.Planet;
import com.example.swapibrowser.retrofit.RetroClient;

public class PlanetsGenerator implements IGenerator<Planet> {

    private final ApiService api = RetroClient.getApiService();

    @Override
    public void getById(String id, ApiResponseListener<Planet> listener) {
        api.getPlanet("planets/" + id).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByFullUrl(String url, ApiResponseListener<Planet> listener) {
        api.getPlanet(url).enqueue(new ApiResponse<>(listener));
    }
}

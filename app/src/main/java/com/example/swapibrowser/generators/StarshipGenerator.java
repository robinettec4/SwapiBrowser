package com.example.swapibrowser.generators;

import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.starship.Starship;
import com.example.swapibrowser.retrofit.RetroClient;

public class StarshipGenerator implements IGenerator<Starship> {

    private final ApiService api = RetroClient.getApiService();

    @Override
    public void getById(String id, ApiResponseListener<Starship> listener) {
        api.getStarship("starships/" + id).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByFullUrl(String url, ApiResponseListener<Starship> listener) {
        api.getStarship(url).enqueue(new ApiResponse<>(listener));
    }
}

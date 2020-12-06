package com.example.swapibrowser.generators;

import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.vehicle.Vehicle;
import com.example.swapibrowser.retrofit.RetroClient;

public class VehicleGenerator implements Generator<Vehicle>{

    private ApiService api = RetroClient.getApiService();

    @Override
    public void getById(String id, ApiResponseListener<Vehicle> listener) {
        api.getVehicle("vehicles/" + id).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByFullUrl(String url, ApiResponseListener<Vehicle> listener) {
        api.getVehicle(url).enqueue(new ApiResponse<>(listener));
    }
}

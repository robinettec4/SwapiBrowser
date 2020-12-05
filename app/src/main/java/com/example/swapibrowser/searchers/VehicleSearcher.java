package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.vehicle.Vehicles;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class VehicleSearcher {

    private ApiService api = RetroClient.getApiService();

    public void getVehicleBySearch(String searchText, ApiResponseListener<Vehicles> listener){
        api.getVehicles("vehicles/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getVehicleById(String id, ApiResponseListener<Vehicles> listener){
        api.getVehicles("vehicles/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getVehiclesByPage(String searchText, ApiResponseListener<Vehicles> listener) {
        api.getVehicles("vehicles/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAllVehicles(ApiResponseListener<Vehicles> listener) {
        api.getVehicles("vehicles/").enqueue(new ApiResponse<>(listener));
    }

    public void getAllVehiclesByPageHelper(String searchText, ApiResponseListener<Vehicles> listener) {
        api.getVehicles(searchText).enqueue(new ApiResponse<>(listener));
    }
}
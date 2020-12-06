package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.vehicle.Vehicles;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class VehiclesSearcher implements Searcher<Vehicles> {

    private ApiService api = RetroClient.getApiService();

    public void getBySearch(String searchText, ApiResponseListener<Vehicles> listener){
        api.getVehicles("vehicles/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getByFullUrl(String url, ApiResponseListener<Vehicles> listener) {
        api.getVehicles(url).enqueue(new ApiResponse<>(listener));
    }

    public void getById(String id, ApiResponseListener<Vehicles> listener){
        api.getVehicles("vehicles/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getByPage(String searchText, ApiResponseListener<Vehicles> listener) {
        api.getVehicles("vehicles/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAll(ApiResponseListener<Vehicles> listener) {
        api.getVehicles("vehicles/").enqueue(new ApiResponse<>(listener));
    }
}
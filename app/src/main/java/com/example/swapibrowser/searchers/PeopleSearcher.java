package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class PeopleSearcher implements ISearcher<People> {

    private final ApiService api = RetroClient.getApiService();

    public void getBySearch(String searchText, ApiResponseListener<People> listener){
        api.getPeople("people/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getByFullUrl(String url, ApiResponseListener<People> listener) {
        api.getPeople(url).enqueue(new ApiResponse<>(listener));
    }

    public void getById(String id, ApiResponseListener<People> listener){
        api.getPeople("people/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getByPage(String searchText, ApiResponseListener<People> listener) {
        api.getPeople("people/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAll(ApiResponseListener<People> listener) {
        api.getPeople("people/").enqueue(new ApiResponse<>(listener));
    }
}

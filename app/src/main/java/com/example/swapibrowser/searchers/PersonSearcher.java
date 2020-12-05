package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class PersonSearcher {

    private ApiService api = RetroClient.getApiService();

    public void getPersonBySearch(String searchText, ApiResponseListener<People> listener){
        api.getPeople("people/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getPersonById(String id, ApiResponseListener<People> listener){
        api.getPeople("people/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getPeopleByPage(String searchText, ApiResponseListener<People> listener) {
        api.getPeople("people/?page=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getAllPeople(ApiResponseListener<People> listener) {
        api.getPeople("people/").enqueue(new ApiResponse<>(listener));
    }

    public void getAllPeopleByPageHelper(String searchText, ApiResponseListener<People> listener) {
        api.getPeople(searchText).enqueue(new ApiResponse<>(listener));
    }
}

package com.example.swapibrowser.generators;

import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.retrofit.RetroClient;

public class PersonGenerator implements Generator<Person> {

    private ApiService api = RetroClient.getApiService();

    @Override
    public void getById(String id, ApiResponseListener<Person> listener) {
        api.getPerson("people/" + id).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByFullUrl(String url, ApiResponseListener<Person> listener) {
        api.getPerson(url).enqueue(new ApiResponse<>(listener));
    }
}

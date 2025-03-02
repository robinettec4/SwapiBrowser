package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.film.Films;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class FilmsSearcher implements ISearcher<Films> {

    private final ApiService api = RetroClient.getApiService();

    public void getBySearch(String searchText, ApiResponseListener<Films> listener){
        api.getFilms("films/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getById(String id, ApiResponseListener<Films> listener){
        api.getFilms("films/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getAll(ApiResponseListener<Films> listener) {
        api.getFilms("films/").enqueue(new ApiResponse<>(listener));
    }

    public void getByFullUrl(String url, ApiResponseListener<Films> listener) {
        api.getFilms(url).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByOrdering(String orderingField, ApiResponseListener<Films> listener) {
        api.getFilms("films/?ordering=" + orderingField).enqueue(new ApiResponse<>(listener));
    }

    public void getByPage(String page, ApiResponseListener<Films> listener) {
        api.getFilms("films/?page=" + page).enqueue(new ApiResponse<>(listener));
    }
}
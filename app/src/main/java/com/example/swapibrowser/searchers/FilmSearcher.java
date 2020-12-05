package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.film.Films;
import com.example.swapibrowser.retrofit.RetroClient;
import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;

public class FilmSearcher {

    private ApiService api = RetroClient.getApiService();

    public void getFilmBySearch(String searchText, ApiResponseListener<Films> listener){
        api.getFilms("films/?search=" + searchText).enqueue(new ApiResponse<>(listener));
    }

    public void getFilmById(String id, ApiResponseListener<Films> listener){
        api.getFilms("films/" + id).enqueue(new ApiResponse<>(listener));
    }

    public void getAllFilms(ApiResponseListener<Films> listener) {
        api.getFilms("films/").enqueue(new ApiResponse<>(listener));
    }
}
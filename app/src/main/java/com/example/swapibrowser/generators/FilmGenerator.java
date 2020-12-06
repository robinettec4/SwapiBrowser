package com.example.swapibrowser.generators;

import com.example.swapibrowser.api.ApiResponse;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.api.ApiService;
import com.example.swapibrowser.models.film.Film;
import com.example.swapibrowser.retrofit.RetroClient;

public class FilmGenerator implements Generator<Film>{

    private ApiService api = RetroClient.getApiService();

    @Override
    public void getById(String id, ApiResponseListener<Film> listener) {
        api.getFilm("films/" + id).enqueue(new ApiResponse<>(listener));
    }

    @Override
    public void getByFullUrl(String url, ApiResponseListener<Film> listener) {
        api.getFilm(url).enqueue(new ApiResponse<>(listener));
    }
}

package com.example.swapibrowser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/{topic}/?search={search}/")
    Call<List<Data>> getData(@Path("topic") String topic, @Path("search") String search);
}

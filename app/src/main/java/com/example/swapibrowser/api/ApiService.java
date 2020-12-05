//James Rudisell

package com.example.swapibrowser.api;

import com.example.swapibrowser.models.person.People;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET()
    Call<People> getPeople(@Url String url);
}

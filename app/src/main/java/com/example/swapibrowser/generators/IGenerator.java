package com.example.swapibrowser.generators;

import com.example.swapibrowser.api.ApiResponseListener;

public interface IGenerator<E> {
    void getById(String id, ApiResponseListener<E> listener);
    void getByFullUrl(String url, ApiResponseListener<E> listener);
}

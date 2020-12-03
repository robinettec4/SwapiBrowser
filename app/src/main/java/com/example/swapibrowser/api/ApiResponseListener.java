package com.example.swapibrowser.api;

public interface ApiResponseListener<ResponseType> {
    void onResponseReceived(ResponseType response);
    void onError();
}

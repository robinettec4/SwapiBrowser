package com.example.swapibrowser.searchers;

import com.example.swapibrowser.api.ApiResponseListener;

public interface ISearcher<E> {
    void getAll(ApiResponseListener<E> listener);
    void getBySearch(String searchText, ApiResponseListener<E> listener);
    void getByFullUrl(String url, ApiResponseListener<E> listener);
    void getByOrdering(String orderingField, ApiResponseListener<E> listener);
    void getByPage(String page, ApiResponseListener<E> listener);
}

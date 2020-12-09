package com.example.swapibrowser.searchers;

public interface ISearcherFactory {
    ISearcher CreateSearcher(String itemType);
}

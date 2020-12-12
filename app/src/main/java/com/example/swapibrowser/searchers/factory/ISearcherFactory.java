package com.example.swapibrowser.searchers.factory;

import com.example.swapibrowser.searchers.ISearcher;

public interface ISearcherFactory {
    ISearcher CreateSearcher(String itemType);
}

package com.example.swapibrowser.models;

import java.util.List;

public interface IModel<E> {
    Integer getCount();
    Object getNext();
    Object getPrevious();
    List<E> getResults();
}

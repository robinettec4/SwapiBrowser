package com.example.swapibrowser.models;

import java.io.Serializable;

public interface ISingleModel<E> extends Serializable {
    String getCreated();
    String getEdited();
    String getUrl();
    String getName();
}

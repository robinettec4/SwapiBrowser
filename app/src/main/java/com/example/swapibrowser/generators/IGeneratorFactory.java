package com.example.swapibrowser.generators;

import java.io.Serializable;

public interface IGeneratorFactory<E> {
    IGenerator<E> CreateGenerator(String itemType);
}

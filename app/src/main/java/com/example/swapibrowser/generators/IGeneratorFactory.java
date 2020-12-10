package com.example.swapibrowser.generators;


public interface IGeneratorFactory<E> {
    IGenerator<E> CreateGenerator(String itemType);
}

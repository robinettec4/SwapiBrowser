package com.example.swapibrowser.generators.factory;


import com.example.swapibrowser.generators.IGenerator;

public interface IGeneratorFactory<E> {
    IGenerator<E> CreateGenerator(String itemType);
}

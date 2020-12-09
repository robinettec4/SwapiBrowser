package com.example.swapibrowser.generators;

public class GeneratorFactory implements IGeneratorFactory {

    @Override
    public IGenerator CreateGenerator(String itemType) {

        if(itemType.equals("film")){
            return new FilmGenerator();
        }
        if(itemType.equals("person")){
            return new PersonGenerator();
        }
        if(itemType.equals("planet")){
            return new PlanetGenerator();
        }
        if(itemType.equals("species")){
            return new SpeciesResultGenerator();
        }
        if(itemType.equals("starship")){
            return new StarshipGenerator();
        }
        if(itemType.equals("vehicle")){
            return new VehicleGenerator();
        } else {
            throw new UnknownError("Unknown Generator Type");
        }
    }
}

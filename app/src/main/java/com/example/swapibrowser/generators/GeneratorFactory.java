package com.example.swapibrowser.generators;

public class GeneratorFactory implements IGeneratorFactory {

    @Override
    public IGenerator CreateGenerator(String itemType) {

        if(itemType.equals("films")){
            return new FilmsGenerator();
        }
        if(itemType.equals("people")){
            return new PeopleGenerator();
        }
        if(itemType.equals("planets")){
            return new PlanetsGenerator();
        }
        if(itemType.equals("species")){
            return new SpeciesGenerator();
        }
        if(itemType.equals("starships")){
            return new StarshipsGenerator();
        }
        if(itemType.equals("vehicles")){
            return new VehiclesGenerator();
        } else {
            throw new UnknownError("Unknown Generator Type");
        }
    }
}

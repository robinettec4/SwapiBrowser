package com.example.swapibrowser.generators.factory;

import com.example.swapibrowser.generators.FilmsGenerator;
import com.example.swapibrowser.generators.IGenerator;
import com.example.swapibrowser.generators.PeopleGenerator;
import com.example.swapibrowser.generators.PlanetsGenerator;
import com.example.swapibrowser.generators.SpeciesGenerator;
import com.example.swapibrowser.generators.StarshipsGenerator;
import com.example.swapibrowser.generators.VehiclesGenerator;

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

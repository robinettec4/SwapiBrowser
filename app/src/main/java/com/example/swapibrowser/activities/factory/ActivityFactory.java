package com.example.swapibrowser.activities.factory;

import com.example.swapibrowser.activities.views.ViewFilm;
import com.example.swapibrowser.activities.views.ViewPerson;
import com.example.swapibrowser.activities.views.ViewPlanet;
import com.example.swapibrowser.activities.views.ViewSpecies;
import com.example.swapibrowser.activities.views.ViewStarship;
import com.example.swapibrowser.activities.views.ViewVehicle;

public class ActivityFactory implements IActivityFactory {
    @Override
    public Class CreateActivity(String itemType) {
        if(itemType.equals("films")){
            return ViewFilm.class;
        }
        if(itemType.equals("people")){
            return ViewPerson.class;
        }
        if(itemType.equals("planets")){
            return ViewPlanet.class;
        }
        if(itemType.equals("species")){
            return ViewSpecies.class;
        }
        if(itemType.equals("starships")){
            return ViewStarship.class;
        }
        if(itemType.equals("vehicles")){
            return ViewVehicle.class;
        } else {
            throw new UnknownError("Unknown View Type");
        }
    }
}

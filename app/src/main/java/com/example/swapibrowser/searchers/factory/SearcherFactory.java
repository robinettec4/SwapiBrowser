package com.example.swapibrowser.searchers.factory;

import com.example.swapibrowser.searchers.FilmsSearcher;
import com.example.swapibrowser.searchers.ISearcher;
import com.example.swapibrowser.searchers.PeopleSearcher;
import com.example.swapibrowser.searchers.PlanetsSearcher;
import com.example.swapibrowser.searchers.SpeciesSearcher;
import com.example.swapibrowser.searchers.StarshipsSearcher;
import com.example.swapibrowser.searchers.VehiclesSearcher;

public class SearcherFactory implements ISearcherFactory {
    
    @Override
    public ISearcher CreateSearcher(String itemType) {

        if(itemType.equals("films")){
            return new FilmsSearcher();
        }
        if(itemType.equals("people")){
            return new PeopleSearcher();
        }
        if(itemType.equals("planets")){
            return new PlanetsSearcher();
        }
        if(itemType.equals("species")){
            return new SpeciesSearcher();
        }
        if(itemType.equals("starships")){
            return new StarshipsSearcher();
        }
        if(itemType.equals("vehicles")){
            return new VehiclesSearcher();
        } else {
            throw new UnknownError("Unknown searcher Type");
        }
    }
}

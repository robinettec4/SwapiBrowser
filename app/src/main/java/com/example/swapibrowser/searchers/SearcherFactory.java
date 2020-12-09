package com.example.swapibrowser.searchers;

public class SearcherFactory implements ISearcherFactory {
    
    @Override
    public ISearcher CreateSearcher(String itemType) {

        if(itemType == "film"){
            return new FilmsSearcher();
        }
        if(itemType == "person"){
            return new PeopleSearcher();
        }
        if(itemType == "planet"){
            return new PlanetsSearcher();
        }
        if(itemType == "species"){
            return new SpeciesSearcher();
        }
        if(itemType == "starship"){
            return new StarshipsSearcher();
        }
        if(itemType == "vehicle"){
            return new VehiclesSearcher();
        } else {
            throw new UnknownError("Unknown searcher Type");
        }
    }
}

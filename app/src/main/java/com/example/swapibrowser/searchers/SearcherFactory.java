package com.example.swapibrowser.searchers;

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

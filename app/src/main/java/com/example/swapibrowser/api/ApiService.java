package com.example.swapibrowser.api;

import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.film.Film;
import com.example.swapibrowser.models.film.Films;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.models.planet.Planet;
import com.example.swapibrowser.models.planet.Planets;
import com.example.swapibrowser.models.species.Species;
import com.example.swapibrowser.models.species.SpeciesResult;
import com.example.swapibrowser.models.starship.Starship;
import com.example.swapibrowser.models.starship.Starships;
import com.example.swapibrowser.models.vehicle.Vehicle;
import com.example.swapibrowser.models.vehicle.Vehicles;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET()
    Call<People> getPeople(@Url String url);

    @GET()
    Call<Person> getPerson(@Url String url);

    @GET()
    Call<Films> getFilms(@Url String url);

    @GET()
    Call<Film> getFilm(@Url String url);

    @GET()
    Call<Species> getSpecies(@Url String url);

    @GET()
    Call<SpeciesResult> getSpeciesResult(@Url String url);

    @GET()
    Call<Starships> getStarships(@Url String url);

    @GET()
    Call<Starship> getStarship(@Url String url);

    @GET()
    Call<Vehicles> getVehicles(@Url String url);

    @GET()
    Call<Vehicle> getVehicle(@Url String url);

    @GET()
    Call<Planets> getPlanets(@Url String url);

    @GET()
    Call<Planet> getPlanet(@Url String url);
}

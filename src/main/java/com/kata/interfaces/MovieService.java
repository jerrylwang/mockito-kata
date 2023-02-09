package com.kata.interfaces;

import com.kata.model.Movie;

import java.util.Collection;
import java.util.Optional;

/**
 * Contract for interactions with the movie service that provides us with enriched and filtered information
 * about sets of movies
 */
public interface MovieService {

    /**
     * Retrieves the first movie whose name matches the name parameter exactly.  There may be no movies that match by
     * this name.
     */
    Optional<Movie> findByTitle(String title);

    /**
     * Retrieves all movies whose name matches the titleRegexp parameter according to the regular expression defined in
     * that parameter.  If no movies are found, this collection will be empty.
     */
    Collection<Movie> fuzzyMatch(String titleRegexp);

    /**
     * Retrieves the first movie to feature the actor. There may be no matches.
     */
    Movie findByCast(String actor);

    /**
     * Retrieves all movies to feature both actors. There may be no matches.
     */
    Collection<Movie> findAllByCast(String actor1, String actor2);

    /**
     * Retrieves all movies with a year between the startYear and endYear inclusive.
     */
    Collection<Movie> findByYears(Integer startYear, Integer endYear);

}

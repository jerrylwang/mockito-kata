package com.kata.service;

import com.kata.interfaces.MovieService;
import com.kata.model.Movie;
import com.kata.repo.MoviesRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {



    public MovieServiceImpl(MoviesRepository repository) {
        this.repository = repository;
    }

    private final MoviesRepository repository;



    @Override
    public Optional<Movie> findByTitle(String title) {
        try {
            return repository.getAll().filter(movie -> movie.getTitle().equals(title)).findFirst();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Movie> fuzzyMatch(String titleRegexp) {
        return null;
    }

    @Override
    public Movie findByCast(String actor) {
        return null;
    }

    @Override
    public Collection<Movie> findAllByCast(String actor1, String actor2) {
        return null;
    }

    @Override
    public Collection<Movie> findByYears(Integer startYear, Integer endYear) {
        return null;
    }
}

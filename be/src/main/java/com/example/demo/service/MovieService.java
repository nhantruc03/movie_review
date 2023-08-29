package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.repo.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
    
    private final MovieRepository movieRepository;

    public Movie add(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(Long id) {
        return movieRepository.findById(id)
            .orElseThrow(()-> new MovieNotFoundException("Movie not found: " + id));
    }

     public Movie deleteById(Long id) {
        Movie movieB4Delete = movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("Movie not found: " + id));

        movieRepository.deleteById(id);

        return movieB4Delete; 
    }

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    
    private final MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<Movie> add(@RequestBody Movie movie){

        return new ResponseEntity<>(movieService.add(movie), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAll(){

        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable("id") Long id ){

        return new ResponseEntity<Movie>(movieService.getById(id), HttpStatus.OK);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteById(@PathVariable("id") Long id ){

        return new ResponseEntity<>(movieService.deleteById(id), HttpStatus.OK);
    }
    

}

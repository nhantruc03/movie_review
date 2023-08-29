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
import com.example.demo.handler.ResHandler;
import com.example.demo.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    
    private final MovieService movieService;
    private final ResHandler resHandler;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Movie movie){

        return  resHandler.generateResponse(movieService.add(movie), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll(){

        return resHandler.generateResponse(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id ){

        return resHandler.generateResponse(movieService.getById(id), HttpStatus.OK);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id ){

        return resHandler.generateResponse(movieService.deleteById(id), HttpStatus.OK);
    }
    

}

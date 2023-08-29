package com.example.demo.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.example.demo.adapter.LocalDateAdapter;
import com.example.demo.auth.AuthenticateResponse;
import com.example.demo.auth.AuthenticateService;
import com.example.demo.auth.ResgisterRequest;
import com.example.demo.entity.Movie;
import com.example.demo.handler.FileHandler;
import com.example.demo.repo.MovieRepository;
import com.example.demo.repo.ReviewRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DefaultData {

    private final MovieRepository movieRepository;
    private final AuthenticateService authenticateService;
    private final FileHandler fileHandler;

    @Value("classpath:test/data.json")
    Resource data;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args ->{

            // movies
            Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
            
            JsonArray jsonArray = new Gson().fromJson(fileHandler.readFiletoString(data), JsonArray.class);

            
            List<Movie> movies = new ArrayList<>();

            jsonArray.forEach(e->{
                Movie movie = gson.fromJson(e.getAsJsonObject().toString(), Movie.class);
                movies.add(movie);
            });

            movieRepository.saveAll(movies);

            // users


            AuthenticateResponse AuthenticateResponse = authenticateService.register(ResgisterRequest.builder()
                .firstName("Nhan")
                .lastName("Pham")
                .email("nhantruc03@gmail.com")
                .password("abc123")
                .build());

            System.out.println(AuthenticateResponse.getToken());
            
        };
    }
    
}

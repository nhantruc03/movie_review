package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repo.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Review addReview(Review review) {

        review.setCreateDate(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    public List<Review> getAll() {
        
        List<Review> res = reviewRepository.findAll();

        return res;
    }

    public List<Review> getAllByMovieId(Long movieId){
        
        return reviewRepository.findByMovie_id(movieId);
    }

    
    
}

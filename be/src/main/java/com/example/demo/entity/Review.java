package com.example.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_Review")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    
    @Id
    @SequenceGenerator(
        name = "review_sequence",
        sequenceName = "review_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
       strategy = GenerationType.SEQUENCE,
       generator = "review_sequence" 
    )
    private Long id;

    private String body;
    private LocalDateTime createDate;

    @JsonBackReference
    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.LAZY)
    @JoinColumn( 
        name = "movie_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private Movie movie;


    @Column(name = "movie_id")
    private Long movie_id;
}

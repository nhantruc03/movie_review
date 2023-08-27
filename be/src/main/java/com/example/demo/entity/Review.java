package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
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

@Data
@Entity
@Table(name = "tbl_Review")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(
        nullable = false, 
        table = "tbl_Movie"
    )
    private Movie movie;

}

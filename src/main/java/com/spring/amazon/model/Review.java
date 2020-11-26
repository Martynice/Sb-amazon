package com.spring.amazon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int externalId;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private int score;
    private int time;
    private String summary;
    private String text;
}

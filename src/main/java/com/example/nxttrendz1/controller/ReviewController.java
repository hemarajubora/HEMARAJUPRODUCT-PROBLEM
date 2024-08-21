package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;
import com.example.nxttrendz1.service.*;

@RestController
public class ReviewController {
    @Autowired
    public ReviewJpaService reviewJpaService;

    @GetMapping("/products/reviews")
    public ArrayList<Review> getReviews() {
        return reviewJpaService.getReviews();
    }

    @PostMapping("/products/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewJpaService.addReview(review);
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review getReview(@PathVariable("reviewId") int reviewId) {
        return reviewJpaService.getReview(reviewId);
    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
        return reviewJpaService.updateReview(reviewId, review);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int reviewId) {
        reviewJpaService.deleteReview(reviewId);
    }

    @GetMapping("/reviews/{reviewId}/products")
    public Product getProductsDetails(@PathVariable("reviewId") int reviewId) {
        return reviewJpaService.getProductsDetails(reviewId);
    }
}
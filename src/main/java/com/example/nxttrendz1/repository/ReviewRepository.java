package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import java.util.ArrayList;

public interface ReviewRepository {
    ArrayList<Review> getReviews();

    Review addReview(Review review);

    Review getReview(int reviewId);

    Review updateReview(int reviewId, Review review);

    void deleteReview(int reviewId);

    Product getProductsDetails(int reviewId);
}

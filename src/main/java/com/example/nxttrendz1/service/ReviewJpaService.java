package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;

@Service
public class ReviewJpaService implements ReviewRepository {
    @Autowired
    private ReviewJpaRepository reviewJpaRepository;
    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Review> getReviews() {
        List<Review> l = reviewJpaRepository.findAll();
        ArrayList<Review> ar = new ArrayList<>(l);
        return ar;
    }

    @Override
    public Review addReview(Review review) {
        Product z = review.getProduct();
        int x = z.getProductId();
        try {
            Product c = productJpaRepository.findById(x).get();
            review.setProduct(c);
            reviewJpaRepository.save(review);
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review getReview(int reviewId) {
        try {
            Review v = reviewJpaRepository.findById(reviewId).get();
            return v;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Review updateReview(int reviewId, Review review) {
        try {
            Review exist = reviewJpaRepository.findById(reviewId).get();

            if (review.getReviewContent() != null) {
                exist.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                exist.setRating(review.getRating());
            }
            if (review.getProduct() != null) {
                Product n = review.getProduct();
                int m = n.getProductId();
                try {
                    Product a = productJpaRepository.findById(m).get();
                    exist.setProduct(a);
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }

            }
            reviewJpaRepository.save(exist);
            return exist;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            Review dig = reviewJpaRepository.findById(reviewId).get();
            reviewJpaRepository.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product getProductsDetails(int reviewId) {
        try {
            Review g = reviewJpaRepository.findById(reviewId).get();
            Product h = g.getProduct();
            return h;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}

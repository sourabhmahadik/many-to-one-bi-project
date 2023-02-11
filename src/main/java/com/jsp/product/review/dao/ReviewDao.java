package com.jsp.product.review.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.product.review.dto.Review;

public class ReviewDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sourabh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Review saveReview(Review review) {
		entityTransaction.begin();
		entityManager.persist(review);
		entityTransaction.commit();
		System.out.println("Review Added");
		return review;
	}

	public Review deleteReview(Review review) {
		Review review2 = entityManager.find(Review.class, review.getId());
		entityTransaction.begin();
		entityManager.remove(review2);
		entityTransaction.commit();
		System.out.println("Review Deleted");
		return review2;
	}

	public Review updateReview(Review review) {
		Review review2 = entityManager.find(Review.class, review.getId());
		if (review2 != null) {
			review2.setRating(review.getRating());
			review2.setStatus(review.getStatus());
			System.out.println("Review Updated");
		} else
			System.out.println("Review not found");

		entityTransaction.begin();
		entityManager.merge(review2);
		entityTransaction.commit();
		return review2;

	}

}

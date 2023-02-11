package com.jsp.product.review.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.product.review.dto.Product;
import com.jsp.product.review.dto.Review;

public class TestDriver {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sourabh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Product product = new Product();
		product.setBrand("Roadster");
		product.setName("roadster");
		product.setCost(1000);
		product.setType("T-Shirt");

		Review r1 = new Review();
		r1.setRating(4);
		r1.setStatus("good");
		r1.setProduct(product);

		Review r2 = new Review();
		r2.setRating(5);
		r2.setStatus("BEST");
		r2.setProduct(product);

		Review r3 = new Review();
		r3.setRating(1);
		r3.setStatus("Expensive");
		r3.setProduct(product);

		ArrayList<Review> al = new ArrayList<Review>();
		al.add(r1);
		al.add(r2);
		al.add(r3);

		product.setReviews(al);

		Product product1 = new Product();
		product1.setBrand("Superstar");
		product1.setName("FILA");
		product1.setCost(8500);
		product1.setType("Shoes");

		Review r4 = new Review();
		r4.setRating(3);
		r4.setStatus("okay");
		r4.setProduct(product1);

		Review r5 = new Review();
		r5.setRating(4);
		r5.setStatus("nice");
		r5.setProduct(product1);

		ArrayList<Review> al1 = new ArrayList<Review>();
		al1.add(r4);
		al1.add(r5);

		product1.setReviews(al1);

		entityTransaction.begin();
		entityManager.persist(product);
		entityManager.persist(product1);
		entityManager.persist(r1);
		entityManager.persist(r2);
		entityManager.persist(r3);
		entityManager.persist(r4);
		entityManager.persist(r5);
		entityTransaction.commit();

	}
}

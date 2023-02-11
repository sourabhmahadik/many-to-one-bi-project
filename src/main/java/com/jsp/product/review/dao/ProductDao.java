package com.jsp.product.review.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.product.review.dto.Product;
import com.jsp.product.review.dto.Review;

public class ProductDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sourabh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Product saveProduct(Product product) {
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		System.out.println("Product Added");
		return product;

	}

	public Product getByIdProduct(int id) {
		return entityManager.find(Product.class, id);
	}

	public Product deleteProduct(Product product) {

		Product product2 = entityManager.find(Product.class, product.getId());
		entityTransaction.begin();
		entityManager.remove(product2);
		entityTransaction.commit();
		System.out.println("Record Deleted");
		return product2;

	}

	public Product updateProduct(Product product) {
		Product product2 = entityManager.find(Product.class, product.getId());

		if (product2 != null) {
			product2.setName(product.getName());
			product2.setBrand(product.getBrand());
			product2.setType(product.getType());
			product2.setCost(product.getCost());
			System.out.println("Record Updated");
		} else
			System.out.println("Record Not Found");

		entityTransaction.begin();
		entityManager.merge(product2);
		entityTransaction.commit();

		return product2;
	}

	public void getAllDetails() {
		String sql = "select product from Product product";
		Query query = entityManager.createQuery(sql);

		List<Product> products = query.getResultList();
		for (Product p1 : products) {
			System.out.println("========================================");
			System.out.println(p1.getId());
			System.out.println(p1.getName());
			System.out.println(p1.getBrand());
			System.out.println(p1.getType());
			System.out.println(p1.getCost());
		}
	}

}

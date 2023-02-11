package com.jsp.product.review.service;

import com.jsp.product.review.dao.ProductDao;
import com.jsp.product.review.dto.Product;

public class ProductService {

	ProductDao productDao = new ProductDao();

	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}

	public Product getByIdProduct(int id) {
		return productDao.getByIdProduct(id);
	}

	public Product deleteProduct(Product product) {
		return productDao.deleteProduct(product);
	}

	public Product updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	public void getAllDetails() {
		productDao.getAllDetails();
	}
}

package org.rabin.dao;

import java.util.List;

import org.rabin.model.Product;

public interface ProductDao {

	void addProduct(Product product);

	Product getProductById(Long id);

	List<Product> getAllProducts();

	void deleteProduct(Long id);

}

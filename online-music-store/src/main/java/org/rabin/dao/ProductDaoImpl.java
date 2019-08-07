package org.rabin.dao;

import java.util.List;

import org.rabin.model.Product;
import org.rabin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}

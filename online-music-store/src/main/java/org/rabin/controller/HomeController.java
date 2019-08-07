package org.rabin.controller;

import java.io.IOException;

import org.rabin.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@Autowired
	private ProductDao productDao;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/productList")
	public String getProducts(Model model) {
		model.addAttribute("products", productDao.getAllProducts());
		return "productList";
	}

	@GetMapping("/productList/viewProduct/{id}")
	public String viewProduct(@PathVariable Long id, Model model) throws IOException {
		System.out.println(productDao.getProductById(id));
		model.addAttribute("product", productDao.getProductById(id));
		return "viewProduct";
	}

	
}

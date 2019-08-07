
package org.rabin.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.rabin.dao.ProductDao;
import org.rabin.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	private ProductDao productDao;

	@GetMapping("")
	public String adminPage() {
		return "admin";
	}

	@GetMapping("/productinventory")
	public String productinventoryPage(Model model) {
		model.addAttribute("products", productDao.getAllProducts());
		return "productInventory";
	}

	@GetMapping("/product/addproduct")
	public String addProductPage(Model model, HttpServletRequest request) {
		Product product = new Product();
		product.setProductCategory("Instrument");
		product.setProductCondition("New");
		product.setProductStatus("active");

		model.addAttribute("product", product);
		return "addproduct";

	}

	@PostMapping("/product/addproduct")
	public String addProduct(@ModelAttribute Product product) {
		System.out.println(product.getProductImage());
		if (product.getProductImage() != null && !(product.getProductImage().isEmpty())) {
			System.out.println("Incoming file......");
			try {
				byte[] bytes = product.getProductImage().getBytes();
				String filePath = "/home/rabin/Desktop/file/music-store/"
						+ product.getProductImage().getOriginalFilename();
				product.setProductImagePath(filePath);
				Path path = Paths.get("/home/rabin/Desktop/file/music-store/",
						product.getProductImage().getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		productDao.addProduct(product);
		return "redirect:/admin/productinventory";
	}

	// edit product page
	@GetMapping("/product/editproduct/{id}")
	public String editProductPage(@PathVariable Long id, Model model) {
		Product product = productDao.getProductById(id);
		model.addAttribute("product", product);
		return "editproduct";
	}

	// save edit page data

	@PostMapping("/product/editproduct")
	public String editPageSave(@RequestParam Long productId, @ModelAttribute Product product) {
		System.out.println(productId);
		return "redirect:/";
	}

	@GetMapping("/product/deleteproduct/{id}")
	public String deleteproduct(@PathVariable Long id) {
		productDao.deleteProduct(id);
		return "redirect:/admin/productinventory";

	}

	@GetMapping("/product/displayimage/{id}")
	@ResponseBody
	public byte[] displayImage(@PathVariable Long id) throws IOException {
		Product product = productDao.getProductById(id);
		String filePath = product.getProductImagePath();
		File serverFile = new File(filePath);
		return Files.readAllBytes(serverFile.toPath());
	}

}

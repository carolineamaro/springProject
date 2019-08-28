package br.com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.dao.ProductDAO;
import br.com.projeto.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO service;
	
	@RequestMapping("/")
	public String pageController(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}
	
	@RequestMapping("/novo")
	public String showNewProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "novo";
	}
	
	
}

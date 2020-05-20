package com.example.boot.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.boot.model.Product;
import com.example.boot.service.IProductService;

@Controller
public class ProductController {
	@Autowired
      private IProductService service;
	@GetMapping("/register.htm")
	public String showHomePage(@ModelAttribute("prodCmd") Product product) {

		return "register";
	}

	@PostMapping("/register.htm")
	public String processFormRequest(Map<String, Object> map, @Valid @ModelAttribute("prodCmd") Product product,
			BindingResult br) {
		if (br.hasErrors()) {
			return "register";
		}
		  service.addProduct(product);
		 
		return "redirect:/process.htm";
	}

	@GetMapping("/process.htmmm")
	public String avodDoublePosting() {

		return "success";
	}
	
	@GetMapping("/process.htm")
	public String fetchAllProduct(Map<String,Object> map) {
		map.putIfAbsent("ob", service.getAll());
		return "productdata";
	}
	@GetMapping("/update")
	public String showEdditPage(@RequestParam("pid") Integer prodId ,@ModelAttribute("product") Product product,Model model) {
		
		product=service.findById(prodId);
		model.addAttribute("product", product);
		return "product_edit";
		
	}
	@PostMapping("/updateproduct")
	public String updateProduct(@Valid @ModelAttribute("product") Product product,Model model,BindingResult br) {
		if(br.hasErrors()) {
			return "product_edit";
		}
		service.addProduct(product);
		model.addAttribute("ob", service.getAll());
		return "productdata";
	}
}

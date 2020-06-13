package com.pawan.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawan.boot.model.OrderMethod;
import com.pawan.boot.service.IOrderMethodService;

@Controller
@RequestMapping("/orderMethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	@GetMapping("/register")
	public String showOrderMethodRegisterPage(@ModelAttribute("orderMethod") OrderMethod orderMethod) {

		return "OrderMethodRegister";
	}

	@PostMapping("/save")
	public String saveOrderMethod(@ModelAttribute("orderMethod") OrderMethod orderMethod, Model model) {

		Integer id = service.saveOrderMethod(orderMethod);
		model.addAttribute("message", "OrderMethod '" + id + "'" + "saved");
		return "OrderMethodRegister";
	}

	@GetMapping("/all")

	public String findAll(Model model) {

		model.addAttribute("orderMethod", new OrderMethod());
		model.addAttribute("list", service.getAllorderMethods());
		return "OrderMethodData";
	}

	@GetMapping("/eddit/{id}")
	public String showOrderMethodEdditForm(@PathVariable Integer id, Model model) {

		if (service.isExist(id)) {

			Optional<OrderMethod> opt = service.getOneOrderMethod(id);
			OrderMethod orderMethod = opt.get();
			model.addAttribute("orderMethod", orderMethod);
			return "OrderMethodEddit";
		} else {
			return "redirect../all";
		}

	}

	@PostMapping("/update")
	public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod, Model model) {

		service.updateorderMethod(orderMethod);
		model.addAttribute("message", "Order updated sucessfully");
		model.addAttribute("list", service.getAllorderMethods());
		return "OrderMethodData";
	}

	@GetMapping("/view/{id}")
	public String viewOne(@PathVariable("id") Integer id, Model model) {
		Optional<OrderMethod> opt = service.getOneOrderMethod(id);
		OrderMethod orderMethod = opt.get();
		model.addAttribute("orderMethod", orderMethod);
		return "OrderView";
	}
}

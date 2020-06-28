package com.pawan.boot.controller;

import java.util.Arrays;
import java.util.Optional;

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
import org.springframework.web.servlet.ModelAndView;

import com.pawan.boot.model.OrderMethod;
import com.pawan.boot.service.IOrderMethodService;
import com.pawan.boot.view.OrderMethodExcelView;

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

	@RequestMapping("/delete/{id}")
	public String deleteOrderMethodById(@PathVariable("id") Integer id, Model model) {

		if (service.isExist(id)) {
			service.deleteorderMethod(id);
			String message = "ordermethod '" + id + "'" + "deleted";
			model.addAttribute("message", message);
			model.addAttribute("list", service.getAllorderMethods());
			return "OrderMethodData";
		} else {

			String message = "ordermethod '" + id + "'" + "not exist";
			model.addAttribute("message", message);
			model.addAttribute("list", service.getAllorderMethods());
			return "OrderMethodData";
		}

	}

	@GetMapping("/excel")
	public ModelAndView exportAll() {

		ModelAndView mv = new ModelAndView();
		mv.setView(new OrderMethodExcelView());
		return mv.addObject("list", service.getAllorderMethods());
	}

	@GetMapping("/excelone/{id}")
	public ModelAndView exportOneOrder(@PathVariable Integer id) {

		ModelAndView mv = new ModelAndView();
		mv.setView(new OrderMethodExcelView());
		Optional<OrderMethod> opt = service.getOneOrderMethod(id);
		if (opt.isPresent())
			mv.addObject("list", Arrays.asList(opt.get()));
		return mv;
	}

	@GetMapping("/code")
	public @ResponseBody String validateOrderMethodCode(@RequestParam("code") String code) {

		String msg = "";
		if (service.isOrderMethodCodeExist(code)) {
			msg = "'"+code+"' already existed";
		}
		return msg;
	}
}

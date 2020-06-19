package com.pawan.boot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pawan.boot.model.Uom;
import com.pawan.boot.service.IUomService;
import com.pawan.boot.view.UomExcelView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@GetMapping("/register")
	public String showUomRegisterPage(Model model) {
		model.addAttribute("uom", new Uom());
		return "UomRegister";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Uom uom, Model model) {
		Integer id = service.saveUom(uom);
		model.addAttribute("uom", new Uom());
		String message = "uom created sucessfully with id:" + id;
		model.addAttribute("message", message);
		return "UomRegister";

	}

	@GetMapping("/findAll")
	public String findAllUom(Model model) {
		List<Uom> list = service.getAllUom();
		model.addAttribute("list", list);
		return "UomData";
	}

	@RequestMapping("/delete/{id}")
	public String deleteUomById(@PathVariable("id") Integer id, Model model) {
		String message = null;

		if (service.isExist(id)) {
			service.deleteUom(id);
			message = "uom having id " + id + "deleted sucessfully";
			model.addAttribute("message", message);
			List<Uom> list = service.getAllUom();
			model.addAttribute("list", list);
			return "UomData";

		} else {
			message = "uom having id " + id + "not existed";
			model.addAttribute("message", message);
			List<Uom> list = service.getAllUom();
			model.addAttribute("list", list);
			return "UomData";
		}

	}

	@GetMapping("/eddit/{id}")
	public String showUomEdditPage(@PathVariable("id") Integer id, Model model) {

		Optional<Uom> opt = service.getOneUom(id);
		if (opt.isPresent()) {

			Uom uom = opt.get();
			model.addAttribute("uom", uom);
			return "UomEdditPage";
		} else {
			String message = "uom is not existed...";
			model.addAttribute("message", message);
		}
		return "UomEdditPage";
	}

	@PostMapping("/update")
	public String updateUomByid(@ModelAttribute("uom") Uom uom, Model model) {

		service.saveUom(uom);
		model.addAttribute("uom", new Uom());
		String message = "uom updated sucessfully";
		List<Uom> list = service.getAllUom();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "UomData";

	}

	@GetMapping("/excel")
	public ModelAndView exportAll() {
		ModelAndView mv = new ModelAndView();
		mv.setView(new UomExcelView());
		return mv.addObject("list", service.getAllUom());
	}

	@GetMapping("/excelone/{id}")
	public ModelAndView exportOneUom(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new UomExcelView());
		Optional<Uom> opt = service.getOneUom(id);
		if (opt.isPresent())
			mv.addObject("list", Arrays.asList(opt.get()));
		return mv;
	}
}

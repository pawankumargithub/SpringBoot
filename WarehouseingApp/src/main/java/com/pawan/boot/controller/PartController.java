package com.pawan.boot.controller;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
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

import com.pawan.boot.model.Part;
import com.pawan.boot.service.IPartService;
import com.pawan.boot.view.PartExcelView;

@Controller
@RequestMapping("/part")
public class PartController {

	private static final Logger log = LoggerFactory.getLogger(PartController.class);

	@Autowired
	private IPartService service;

	@RequestMapping(value = "/error")
	public String getErrorMessage() {

		return "ErrorPage";

	}

	@GetMapping("/register")

	public String showPartRegisterPage(@ModelAttribute Part part, Model model) {

		log.info("enter inside register method");
		model.addAttribute("part", part);
		return "PartRegister";
	}

	@PostMapping("/save")
	public String savePart(@ModelAttribute Part part, Model model) {
		log.info("enter inside save method");
		try {

			Integer id = service.savePart(part);
			model.addAttribute("message", "part:" + id + "saved");
			log.debug("saved the data having id:" + id);
		} catch (Exception e) {

			log.error("coul not save data:" + e.getMessage());
		}

		return "PartRegister";
	}

	@GetMapping("/all")
	public String findAllPart(Model model) {
		log.info("enter inside the findall method");
		try {
			model.addAttribute("list", service.getAllParts());
			log.debug("data fetched successfully" + service.getAllParts());
		} catch (Exception e) {
			log.error("could not fetched data");
		}

		return "PartData";

	}

	@RequestMapping("/delete/{id}")
	public String deletePart(@PathVariable Integer id, Model model) {

		try {
			log.info("eneter inside delete method");
			service.deletePart(id);
			log.debug("part deleted having id:" + id);
			model.addAttribute("list", service.getAllParts());

		} catch (Exception e) {
			log.error("could not deleted part having id:" + id + " " + e.getMessage());
		}
		return "PartData";
	}

	@GetMapping("/eddit/{id}")
	public String showUpdatePage(@PathVariable Integer id, @ModelAttribute Part part, Model model) {

		log.info("enter inside show eddit page method");
		try {
			log.info("fetching data");
			Optional<Part> opt = service.getOnePart(id);
			if (opt.isPresent()) {

				part = opt.get();
				model.addAttribute("part", part);
				log.debug("data fetched:data is :" + part);
			}
		} catch (Exception e) {
			log.error("could not show eddit page" + e.getMessage());
		}

		return "PartDataEddit";
	}

	@PostMapping("/update")
	public String updatePart(@ModelAttribute Part part, Model model) {

		log.info("enter inside update method");
		try {
			log.info("updating part having code :" + part.getPartCode());
			service.updatePart(part);
			log.debug("successfully updated part having id and code:" + part.getId() + " " + part.getPartCode());
			model.addAttribute("list", service.getAllParts());
			log.debug("finally fetching latest updated data " + service.getAllParts());
		} catch (Exception e) {
			log.error("could not update:" + e.getMessage());
		}

		return "PartData";
	}

	@GetMapping("/excel")
	public ModelAndView excelImport() {
		log.info("inside excelimport method");
		ModelAndView mv = new ModelAndView();
		try {

			mv.setView(new PartExcelView());
			log.debug("data sent to excel successfully");
		} catch (Exception e) {

			log.error("coul not export to excel sheet:" + e.getMessage());
		}

		return mv.addObject("list", service.getAllParts());
	}

	@GetMapping("/excelone/{id}")
	public ModelAndView exportOnePart(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		log.info("inside export one part method");
		try {
			mv.setView(new PartExcelView());
			log.info("fetching onne part data");

			Optional<Part> opt = service.getOnePart(id);
			if (opt.isPresent()) {
				log.info("inside if condition");
				mv.addObject("list", Arrays.asList(opt.get()));
				log.debug("sent successfully to ui");

			}
		} catch (Exception e) {
			log.error("could not export to excel:" + e.getMessage());
		}
		return mv;
	}

	@GetMapping("/partCode")
	public @ResponseBody String validatePartCode(@RequestParam String code) {
		log.info("eneter inside validatePartCode()");
		String msg = "";
		try {
			if (service.isPartCodeExist(code)) {
				msg = "part code already existed";
				log.debug(msg);
			}
		} catch (Exception e) {
			log.error("could not validated code:" + e.getMessage());
		}
		return msg;

	}

}

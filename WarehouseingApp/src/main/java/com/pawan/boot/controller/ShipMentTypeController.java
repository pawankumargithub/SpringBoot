package com.pawan.boot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.pawan.boot.model.ShipmentType;
import com.pawan.boot.service.IShipmentTypeService;
import com.pawan.boot.view.ShipmentTypeExcelView;

@Controller
@RequestMapping("/shipMenttype")
public class ShipMentTypeController {

	private static final Logger log=LoggerFactory.getLogger(ShipMentTypeController.class);
	@Autowired
	private IShipmentTypeService service;

	@GetMapping("/register")
	public String showRegister(Model model) {

		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";

	}

	@PostMapping("/save")
	public String save(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipment(shipmentType);
		String message = "shipmentcreated successfully with id:" + id;
		model.addAttribute("msg", message);
		return "ShipmentTypeRegister";
	}

	@GetMapping("/getAll")
	public String findAllShipments(Model model) {

		List<ShipmentType> list = service.getAllShipments();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	@RequestMapping("/delete/{id}")
	public String deleteShipmentById(@PathVariable("id") Integer id, Model model) {
		String message = null;
		if (service.isExist(id)) {

			service.deleteShipment(id);
			message = "shipment deleted sucessfully";
			model.addAttribute("message", message);
			List<ShipmentType> list = service.getAllShipments();
			model.addAttribute("list", list);
			return "ShipmentTypeData";
		} else {
			message = "the shipment is not existed having id:" + id;
			model.addAttribute("message", message);
			List<ShipmentType> list = service.getAllShipments();
			model.addAttribute("list", list);
			return "ShipmentTypeData";
		}

	}

	@GetMapping("/eddit/{id}")
	public String showShipmentTypeEdditForm(@PathVariable("id") Integer id, Model model) {

		Optional<ShipmentType> opt = service.getOneShipment(id);
		if (opt.isPresent()) {

			ShipmentType shipmentType = opt.get();
			model.addAttribute("shipmentType", shipmentType);
			return "ShipmentTypeEddit";
		} else {
			return "redirct:/getAll";
		}

	}

	@PostMapping("/update")
	public String updateShipmentById(@ModelAttribute ShipmentType shipmentType, Model model) {

		Integer id = service.saveShipment(shipmentType);
		String message = "shipment updated successfully with id:" + id;
		model.addAttribute("message", message);
		List<ShipmentType> list = service.getAllShipments();
		model.addAttribute("list", list);

		return "ShipmentTypeData";

	}

	@GetMapping("/exceldata")
	public ModelAndView excelExport() {

		ModelAndView view = new ModelAndView();
		view.setView(new ShipmentTypeExcelView());
		view.addObject("list", service.getAllShipments());
		return view;

	}

	@GetMapping("/exceldataone/{id}")
	public ModelAndView excelExportOne(@PathVariable Integer id) {

		ModelAndView view = new ModelAndView();
		view.setView(new ShipmentTypeExcelView());
		Optional<ShipmentType> opt = service.getOneShipment(id);
		if (opt.isPresent())
			view.addObject("list", Arrays.asList(opt.get()));
		return view;

	}
	@GetMapping("/validateCode")
	public @ResponseBody String validateShipmentCode(@RequestParam String code) {
		String msg="";
		
		if(service.isShipmentTypeCodeExists(code)) {
			msg="'"+code+"' already existed";
		}
		return msg;
		
	}

}

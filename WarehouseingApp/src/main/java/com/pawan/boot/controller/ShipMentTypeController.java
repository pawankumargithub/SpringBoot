package com.pawan.boot.controller;

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

import com.pawan.boot.model.ShipmentType;
import com.pawan.boot.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipMenttype")
public class ShipMentTypeController {

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
		String message = "shipment updated successfully with id:"+id;
		model.addAttribute("message", message);
		List<ShipmentType> list = service.getAllShipments();
		model.addAttribute("list", list);
		
		return "ShipmentTypeData";
	
	}
	
}
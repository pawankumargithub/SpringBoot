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

import com.pawan.boot.model.WhUserType;
import com.pawan.boot.service.IWhUserTypeService;
import com.pawan.boot.util.EmailSender;
import com.pawan.boot.view.WhUserTypeExcelView;

@Controller
@RequestMapping("/whUserType")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private EmailSender sender;

	@GetMapping("/register")
	public String showWhUserTypeRegisterPage(Model model) {

		model.addAttribute("whUserType", new WhUserType());

		return "WhUserTypeRegister";

	}

	@PostMapping("/save")
	public String saveWhUserType(@ModelAttribute WhUserType whUserType, Model model) {

		Integer id = service.saveWhuserType(whUserType);
		model.addAttribute("whUserType", new WhUserType());
		String message = "WhUser '" + id + "'" + "saved successfully";

		if (id != 0) {

			boolean status = sender.sendMail(whUserType.getUserMail(), "welcome", whUserType.getUserCode());
			if (status)
				message += "email also sent";
			else
				message += "email not sent";
		}
		model.addAttribute("message", message);
		return "WhUserTypeRegister";
	}

	@GetMapping("/all")
	public String findWhuserypes(Model model) {

		model.addAttribute("list", service.getAllWhuserTypes());
		return "WhUserTypeData";
	}

	@RequestMapping("/delete/{id}")
	public String deleteWhUserTypeById(@PathVariable("id") Integer id, Model model) {

		if (service.isExist(id)) {

			service.deleteWhuserType(id);
			model.addAttribute("message", "WhUser '" + id + "'" + "deleted");
			model.addAttribute("list", service.getAllWhuserTypes());
			return "WhUserTypeData";
		} else {
			model.addAttribute("message", "WhUser '" + id + "'" + "not exist..");
			return "WhUserTypeData";
		}
	}

	@GetMapping("/eddit/{id}")
	public String showWhUserTypeEdditPage(@PathVariable("id") Integer id, Model model) {

		if (service.isExist(id)) {
			Optional<WhUserType> opt = service.getOneWhuserType(id);
			WhUserType whUserType = opt.get();
			model.addAttribute("whUserType", whUserType);
			return "WhUserTypeEddit";
		}

		return "redirect../all";

	}

	@PostMapping("/update")
	public String update(@ModelAttribute WhUserType whUserType, Model model) {

		service.updateWhuserType(whUserType);
		model.addAttribute("message", "WhUser '" + whUserType.getId() + "'  updated successfuly");
		model.addAttribute("list", service.getAllWhuserTypes());
		return "WhUserTypeData";

	}

	@GetMapping("/view/{id}")
	public String getOneWhUserType(@PathVariable("id") Integer id, Model model) {
		if (service.isExist(id)) {
			Optional<WhUserType> opt = service.getOneWhuserType(id);
			WhUserType whUserType = opt.get();
			model.addAttribute("whUserType", whUserType);
			return "WhUserTypeView";
		} else {
			model.addAttribute("message", "data not existed");
			return "redirect../all";
		}

	}

	@GetMapping("/excel")
	public ModelAndView exportAll() {

		ModelAndView mv = new ModelAndView();
		mv.setView(new WhUserTypeExcelView());
		mv.addObject("list", service.getAllWhuserTypes());
		return mv;

	}

	@GetMapping("/excelone/{id}")
	public ModelAndView exportOneWhUser(@PathVariable Integer id) {

		ModelAndView mv = new ModelAndView();
		mv.setView(new WhUserTypeExcelView());
		Optional<WhUserType> opt = service.getOneWhuserType(id);
		if (opt.isPresent())
			mv.addObject("list", Arrays.asList(opt.get()));
		return mv;

	}

	@GetMapping("/validateUserCode")

	public @ResponseBody String valdateUserCode(@RequestParam String code) {

		System.out.println("WhUserTypeController.valdateUserCode()");
		String msg = "";
		if (service.isUserCodeExist(code)) {

			msg = " '" + code + "' is already  exsisted";
		}
		return msg;

	}

	@GetMapping("/email")
	public @ResponseBody String validateUserMail(@RequestParam("mail") String mail) {

		String msg = "";
		if (service.isUserEmailExist(mail)) {
			msg = "'" + mail + "'already existed";
		}
		return msg;
	}

	@GetMapping("/usercontact")
	public @ResponseBody String validateUserContact(@RequestParam("contact") String contact) {

		String msg = "";
		if (service.isUserContactExist(contact)) {
			msg = "'" + contact + "' already existed";
		}
		return msg;
	}
}

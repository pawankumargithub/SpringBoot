package com.pawan.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawan.boot.command.BookCommand;
import com.pawan.boot.dto.BookDTO;
import com.pawan.boot.exception.NoBookFoundException;
import com.pawan.boot.service.IBookService;

@Controller

public class BookController {

	@Autowired
	private IBookService service;

	@GetMapping("/regbook")
	public String showBookRegisterPage() {

		return "book_register";
	}

	@PostMapping("/savebook")
	public String saveBook(@ModelAttribute BookCommand cmd, Model model) {

		BookDTO dto = new BookDTO();
		BeanUtils.copyProperties(cmd, dto);
		dto = service.saveBook(dto);
		model.addAttribute("id", dto.getBookId());
		return "book_register";
	}

	@GetMapping("/findall")
	public String findAll(@ModelAttribute BookCommand cmd, Model model) {
		List<BookDTO> listDto = new ArrayList<BookDTO>();
		List<BookCommand> commandList = new ArrayList<BookCommand>();
		listDto = service.findAllBooks();
		for (BookDTO bookDTO : listDto) {

			BeanUtils.copyProperties(bookDTO, cmd);
			commandList.add(cmd);
		}

		model.addAttribute("commandList", listDto);
		return "book_list";

	}

	@RequestMapping("/delete")
	public String deleteOneBookById(@RequestParam("pid") Integer id, Model model) {

		boolean exist = service.isBookExist(id);
		if (exist) {
			service.deleteOneBookById(id);
		}
		List<BookDTO> listDto = service.findAllBooks();

		model.addAttribute("commandList", listDto);
		return "book_list";
	}

	@RequestMapping("/deleteAll")
	public String deleteAllBooks(Model model) {

		service.deleteAllBooks();
		List<BookDTO> listDto = service.findAllBooks();

		model.addAttribute("commandList", listDto);
		return "book_list";
	}

	@RequestMapping("/showUpdate")
	public String showBookUpdatePage(@RequestParam("pid") Integer id, @ModelAttribute("cmd") BookCommand cmd,
			Model model) {

		BookDTO dto = service.findOneBookById(id);
		BeanUtils.copyProperties(dto, cmd);
		cmd.setBookId(dto.getBookId());
		cmd.setBookName(dto.getBookName());
		cmd.setBookPrice(dto.getBookPrice());
		cmd.setBookAuthor(dto.getBookAuthor());
		model.addAttribute("cmd", cmd);
		return "book_update";

	}

	@PostMapping("/update")
	public String updateOneBookById(@ModelAttribute("cmd") BookCommand cmd, Model model) {
		BookDTO dto = new BookDTO();
		BeanUtils.copyProperties(cmd, dto);

		dto = service.saveBook(dto);
		List<BookDTO> listDto = service.findAllBooks();
		model.addAttribute("commandList", listDto);
		model.addAttribute("id", "book updated having id::" + dto.getBookId());
		return "book_list";

	}
	@GetMapping("/getonebookform")
	public String showFindOneBookFormPage(@ModelAttribute("cmd") BookCommand cmd) {
		
		return "search";
	}

	@PostMapping("/getonebook")
	public String findBookById(@ModelAttribute("cmd") BookCommand cmd,Model model) {
	
		BookDTO dto=new BookDTO();
		BeanUtils.copyProperties(cmd, dto);
		dto=service.findOneBookById(dto.getBookId());
		 if(dto.getBookId()!=cmd.getBookId()) {
			 throw new NoBookFoundException("not book existed");
		 }
		BeanUtils.copyProperties(dto, cmd);
		 
		model.addAttribute("cmd", cmd);
		return "onebookdata";
		
		
	}
}

package com.pawan.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pawan.boot.model.Document;
import com.pawan.boot.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {

	private static final Logger log = LoggerFactory.getLogger(DocumentController.class);
	@Autowired
	private IDocumentService service;

	@GetMapping("/upload")
	public String showUplLoadPage(@ModelAttribute Document document, Model model) {

		log.info("inside document register method");
		model.addAttribute("document", document);
		return "DocumentUpload";
	}

	@PostMapping("/save")
	public String uploadDocument(@RequestParam Integer fileId, @RequestParam MultipartFile fileOb) {
		log.info("inside document save method");
		try {
			if (fileOb != null && fileId != null) {
				log.info("inside document save method if block");
				Document document = new Document();
				document.setDocId(fileId);
				document.setDocName(fileOb.getOriginalFilename());
				try {
					log.info("inside document save method if block try block");
					document.setDocData(fileOb.getBytes());
					log.info("saving document:" + document);
					service.saveDocument(document);
					log.debug("document saved successfuly with id:" + document.getDocId());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		} catch (Exception e) {
			log.error("could not upload document:" + e.getMessage());
		}

		return "redirect:all";

	}

	@GetMapping("/all")

	public String showDocs(Model model) {
		log.info("inside showDocs method");
		log.debug("fetching list of document");
		model.addAttribute("list", service.findIdAndName());
		log.info("documents fetched successfully data is:" + service.findIdAndName());
		return "DocumentUpload";
	}

}

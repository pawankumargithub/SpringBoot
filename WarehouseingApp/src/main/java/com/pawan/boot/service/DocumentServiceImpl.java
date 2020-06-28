package com.pawan.boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pawan.boot.model.Document;
import com.pawan.boot.repossitory.DocumentRepository;

@Service
public class DocumentServiceImpl implements IDocumentService {

	private static final Logger log = LoggerFactory.getLogger(DocumentServiceImpl.class);
	@Autowired
	private DocumentRepository repo;

	@Override
	public void saveDocument(Document document) {

		log.info("inside DocumentServiceImpl saveDocument method ");
		repo.save(document);
		log.debug("inside DocumentServiceImpl saveDocument method document saved");
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> findIdAndName() {
		log.info("inside DocumentServiceImpl findIdAndName() method ");
		return repo.findIdAndName();

	}

}

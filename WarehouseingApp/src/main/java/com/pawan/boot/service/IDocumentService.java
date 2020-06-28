package com.pawan.boot.service;

import java.util.List;

import com.pawan.boot.model.Document;

public interface IDocumentService {

	public void saveDocument(Document document);
	public List<Object[]> findIdAndName();
}

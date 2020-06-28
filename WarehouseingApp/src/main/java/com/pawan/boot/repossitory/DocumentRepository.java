package com.pawan.boot.repossitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pawan.boot.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

	@Query(" select doc.docId, doc.docName from Document doc ")
	 List<Object[]> findIdAndName();
}

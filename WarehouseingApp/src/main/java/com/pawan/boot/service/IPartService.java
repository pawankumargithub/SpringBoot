package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;


import com.pawan.boot.model.Part;

public interface IPartService {

	Integer savePart(Part part);

	void updatePart(Part part);

	void deletePart(Integer id);

	List<Part> getAllParts();

	Optional<Part> getOnePart(Integer id);

	boolean isPartExist(Integer id);

	boolean isPartCodeExist(String code);
}

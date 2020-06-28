package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.boot.model.Part;
import com.pawan.boot.repossitory.PartRepository;

@Service
public class PartServiceImpl implements IPartService {

	@Autowired
	private PartRepository repo;

	@Override
	public Integer savePart(Part part) {

		return repo.save(part).getId();
	}

	@Override
	public void updatePart(Part part) {

		repo.save(part);
	}

	@Override
	public void deletePart(Integer id) {

		repo.deleteById(id);
	}

	@Override
	public List<Part> getAllParts() {

		return repo.findAll();
	}

	@Override
	public Optional<Part> getOnePart(Integer id) {
		Optional<Part> opt = repo.findById(id);
		return opt;
	}

	@Override
	public boolean isPartExist(Integer id) {

		return repo.existsById(id);
	}

	@Override
	public boolean isPartCodeExist(String code) {
		Integer count = repo.countByPartCode(code);
		return (count > 0 ? true : false);
	}

}

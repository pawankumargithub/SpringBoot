package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.boot.model.Uom;
import com.pawan.boot.repossitory.UomRepository;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private UomRepository repo;
	@Override
	public Integer saveUom(Uom uom) {
	Integer id=repo.save(uom).getId();
		return id;
	}

	@Override
	public void updateUom(Uom uom) {
		repo.save(uom);

	}

	@Override
	public void deleteUom(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public List<Uom> getAllUom() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Uom> getOneUom(Integer id) {
	Optional<Uom> opt=repo.findById(id);
	   
		return opt;
	}

	@Override
	public boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

}

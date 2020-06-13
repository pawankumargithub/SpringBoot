package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.boot.model.WhUserType;
import com.pawan.boot.repossitory.WhUserTypeRepository;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private WhUserTypeRepository repo;

	@Override
	public Integer saveWhuserType(WhUserType whuserType) {
		
		return repo.save(whuserType).getId();
	}

	@Override
	public void updateWhuserType(WhUserType WhuserType) {
		repo.save(WhuserType);

	}

	@Override
	public void deleteWhuserType(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public List<WhUserType> getAllWhuserTypes() {
		return repo.findAll();
	}

	@Override
	public Optional<WhUserType> getOneWhuserType(Integer id) {
		Optional<WhUserType> opt = repo.findById(id);
		return opt;
	}

	@Override
	public boolean isExist(Integer id) {
		return repo.existsById(id);
	}

}

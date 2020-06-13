package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pawan.boot.model.ShipmentType;
import com.pawan.boot.repossitory.ShipmentTypeRepository;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private ShipmentTypeRepository repo;

	@Override
	@Transactional
	public Integer saveShipment(ShipmentType st) {
		Integer id = repo.save(st).getId();

		return id;
	}

	@Override
	@Transactional
	public void updateShipment(ShipmentType st) {
		repo.save(st);

	}

	@Override
	@Transactional
	public void deleteShipment(Integer id) {

		repo.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipments() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ShipmentType> getOneShipment(Integer id) {
		Optional<ShipmentType> opt = repo.findById(id);
		return opt;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id) {

		return repo.existsById(id);
	}

}

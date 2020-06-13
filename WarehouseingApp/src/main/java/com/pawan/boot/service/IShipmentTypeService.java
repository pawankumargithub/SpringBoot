package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import com.pawan.boot.model.ShipmentType;

public interface IShipmentTypeService {

	Integer saveShipment(ShipmentType st);

	void updateShipment(ShipmentType st);

	void deleteShipment(Integer id);

	List<ShipmentType> getAllShipments();

	Optional<ShipmentType> getOneShipment(Integer id);

	boolean isExist(Integer id);
}

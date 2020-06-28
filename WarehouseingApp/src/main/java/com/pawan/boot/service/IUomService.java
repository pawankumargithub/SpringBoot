package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import com.pawan.boot.model.Uom;

public interface IUomService {

	Integer saveUom(Uom uom);

	void updateUom(Uom uom);

	void deleteUom(Integer id);

	List<Uom> getAllUom();

	Optional<Uom> getOneUom(Integer id);

	boolean isExist(Integer id);

	boolean isUomModelExist(String model);

}

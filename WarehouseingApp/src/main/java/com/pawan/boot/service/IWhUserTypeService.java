package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import com.pawan.boot.model.WhUserType;

public interface IWhUserTypeService {

	Integer saveWhuserType(WhUserType whuserType);

	void updateWhuserType(WhUserType WhuserType);

	void deleteWhuserType(Integer id);

	List<WhUserType> getAllWhuserTypes();

	Optional<WhUserType> getOneWhuserType(Integer id);

	boolean isExist(Integer id);

	boolean isUserCodeExist(String userCode);

	boolean isUserEmailExist(String email);

	boolean isUserContactExist(String contact);
}

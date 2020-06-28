package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional(readOnly = true)
	public boolean isUserCodeExist(String userCode) {

		Integer count = repo.findByUserCode(userCode);
		System.out.println(count);

		boolean flag = (count > 0 ? true : false);
		return flag;
	}

	@Override
	public boolean isUserEmailExist(String mail) {

		Integer count = repo.countByUserMail(mail);
		System.out.println(count);

		return (count > 0 ? true : false);
	}

	@Override
	public boolean isUserContactExist(String contact) {
		Integer count = repo.countByUserContact(contact);
		return (count > 0 ? true : false);
	}
}

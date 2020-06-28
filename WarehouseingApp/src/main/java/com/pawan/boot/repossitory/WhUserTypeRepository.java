package com.pawan.boot.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pawan.boot.model.WhUserType;

public interface WhUserTypeRepository extends JpaRepository<WhUserType, Integer> {

	@Query("SELECT COUNT(WH.userCode) FROM WhUserType WH WHERE WH.userCode=:code ")
	public Integer findByUserCode(String code);

	@Query("select count(userMail) from WhUserType where userMail=:mail")
	public Integer countByUserMail(String mail);
	
	@Query("select count(userContact) from WhUserType where userContact=:contact")
	public Integer countByUserContact(String contact);
}

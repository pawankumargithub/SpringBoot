package com.pawan.mvc.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pawan.mvc.bo.PatientBO;
import com.pawan.mvc.dao.PatientDAO;
import com.pawan.mvc.utility.HibernateUtility;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@Override
	public Integer insertPatient(PatientBO bo) {
		Session ses=HibernateUtility.sessionFactory().openSession();
		Integer id=null;
		Transaction tx=null;
		try {
			
			
			tx=ses.beginTransaction();
			
		 id=(Integer)ses.save(bo);
			tx.commit();
			ses.close();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return id;
	}

}

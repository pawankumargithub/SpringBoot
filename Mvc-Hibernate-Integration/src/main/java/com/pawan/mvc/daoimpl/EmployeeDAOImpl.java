package com.pawan.mvc.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.pawan.mvc.dao.EmployeeDAO;
import com.pawan.mvc.model.Employee;
import com.pawan.mvc.utility.HibernateUtility;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Integer saveEmployee(Employee employee) {

		Session ses = HibernateUtility.sessionFactory().openSession();
		Transaction tx = null;
		try (ses) {
			tx = ses.beginTransaction();

			ses.save(employee);

			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return employee.getEmpId();
	}

	@Override
	public Iterable<Employee> fetchAll() throws Exception {

		Session ses = HibernateUtility.sessionFactory().openSession();



		Query q = ses.createQuery("FROM Employee");
		List<Employee> list=q.list();
		list.forEach(System.out::println);


		return list;
	}

}

package com.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;

public class CreateData {

	public static void main(String[] args) {

		SessionFactory sessionFact = HibernateUtil.getSessionFactory();
		Session session = sessionFact.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Employee emp = new Employee();

		emp.setEmpName("Pramod");
		emp.setEmpAddress("Bengaluru");
		emp.setEmpMobieNos("9772227979");
		session.save(emp);	

		System.out.println("Successfully inserted");
		CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
		cq.from(Employee.class);
		List<Employee> employeeList = session.createQuery(cq).getResultList();
		for (Employee employee : employeeList) {
			System.out.println("ID : " + employee.getId() + "\n" + "Name : " + employee.getEmpName());
		}
		tr.commit();
		sessionFact.close();
	}

}

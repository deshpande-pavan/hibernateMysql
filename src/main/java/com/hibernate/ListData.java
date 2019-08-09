package com.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;

public class ListData {

	public static void main(String[] args) {
		SessionFactory sessionFact = HibernateUtil.getSessionFactory();
		Session session = sessionFact.getCurrentSession();
		Transaction tr = session.beginTransaction();
		CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
		cq.from(Employee.class);
		List<Employee> employeeList = session.createQuery(cq).getResultList();
		for (Employee employee : employeeList) {
			System.out.println("ID : " + employee.getId() + "\n" + "Name : " + employee.getEmpName());
		}
		tr.commit();
		System.out.println("Data Printed");
		sessionFact.close();
	}
}

package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pavan
 * 
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * @author Pavan
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_address")
	private String empAddress;
	@Column(name = "emp_mobile_nos")
	private String empMobieNos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpMobieNos() {
		return empMobieNos;
	}

	public void setEmpMobieNos(String empMobieNos) {
		this.empMobieNos = empMobieNos;
	}

}

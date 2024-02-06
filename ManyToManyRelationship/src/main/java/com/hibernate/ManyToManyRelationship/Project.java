package com.hibernate.ManyToManyRelationship;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int id;
	
	@Column(name = "p_name")
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "pro_emp_mapping",
			joinColumns = {@JoinColumn(name = "p_id")},
			inverseJoinColumns = {@JoinColumn(name = "emp_id")}
	)
	private List<Employee> employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", employee=" + employee + "]";
	}

	
}

package com.greatlearning.lab5.mvcproject.service;

import java.util.List;

import com.greatlearning.lab5.mvcproject.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);
}

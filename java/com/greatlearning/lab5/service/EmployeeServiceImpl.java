package com.greatlearning.lab5.mvcproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.lab5.mvcproject.dao.EmplyeeDao;
import com.greatlearning.lab5.mvcproject.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmplyeeDao emplyeeDao;

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = emplyeeDao.findAll();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> employeeFromDB = emplyeeDao.findById(id);
		Employee employee = null;
		if (employeeFromDB.isPresent()) {
			employee = employeeFromDB.get();
		} else {
			throw new RuntimeException("Employee doesn't exist: " + id);
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		emplyeeDao.save(employee);
	}

	@Override
	public void deleteById(int id) {
		emplyeeDao.deleteById(id);
	}

}

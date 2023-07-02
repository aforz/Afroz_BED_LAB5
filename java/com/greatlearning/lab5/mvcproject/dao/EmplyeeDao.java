package com.greatlearning.lab5.mvcproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.lab5.mvcproject.entity.Employee;

public interface EmplyeeDao extends JpaRepository<Employee, Integer> {

}

package com.greatlearning.lab5.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.lab5.entity.Employee;

public interface EmplyeeDao extends JpaRepository<Employee, Integer> {

}

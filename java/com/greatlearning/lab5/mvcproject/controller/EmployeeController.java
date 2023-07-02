package com.greatlearning.lab5.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.lab5.mvcproject.entity.Employee;
import com.greatlearning.lab5.mvcproject.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> employees = employeeService.findAll();
		theModel.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@GetMapping("/add")
	public String addEmployee(Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employee", employee);
		return "employees/employee-form";
	}

	@PostMapping("/update")
	public String updateEmployee(@RequestParam("id") int id, Model theModel) {
		Employee employee = employeeService.findById(id);
		theModel.addAttribute("employee", employee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";

	}

}

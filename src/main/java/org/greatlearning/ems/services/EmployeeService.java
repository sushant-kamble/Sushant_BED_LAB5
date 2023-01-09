package org.greatlearning.ems.services;

import java.util.List;

import org.greatlearning.ems.entities.Employee;

public interface EmployeeService {
	Employee insertEmployee(Employee employee);
	void deleteEmployeeById(int id);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee e);
	
}

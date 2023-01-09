package org.greatlearning.ems.services;

import java.util.List;

import org.greatlearning.ems.entities.Employee;
import org.greatlearning.ems.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRepository;
	
	public EmpServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee insertEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee e) {
		return employeeRepository.save(e);
	}

}

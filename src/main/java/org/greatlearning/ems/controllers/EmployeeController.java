package org.greatlearning.ems.controllers;

import java.util.List;

import org.greatlearning.ems.entities.Employee;
import org.greatlearning.ems.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		List<Employee> employees=employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		return "employees";
	}
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.insertEmployee(employee);
		return "redirect:/employees";
	}
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable("id") int id,Model model) {
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "edit_employee";
	}
	@PostMapping("/employees/{id}")
	public String updateEmpployee(@PathVariable("id") int id,@ModelAttribute("employee") Employee employee) {
		Employee existingEmployee=employeeService.getEmployeeById(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeService.insertEmployee(existingEmployee);
		return "redirect:/employees";
	}
	
}

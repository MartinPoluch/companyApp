package com.poluch.martin.companyApp.controller;

import java.util.Collection;
import java.util.List;
import com.poluch.martin.companyApp.entity.Employee;
import com.poluch.martin.companyApp.entity.Position;
import com.poluch.martin.companyApp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@ModelAttribute("positions")
	public Collection<Position> allPositions(){
		return employeeService.findAllPositions();
	}

	@GetMapping("")
	public String index(Model model) {
		List<Employee> theEmployees = employeeService.findAll();
		model.addAttribute("employees", theEmployees);
		return "employees/list-employees";
	}

	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("employee", new Employee());
	    return "employees/employee-form";
    }

	@GetMapping("/edit/{employeeId}")
	public String showUpdateForm(@PathVariable("employeeId") int id, Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/";
	}

	@GetMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/";
	}
}










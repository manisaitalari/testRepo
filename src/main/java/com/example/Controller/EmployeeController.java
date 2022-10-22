package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EmployeeDetails;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveDetails")
	public ResponseEntity<String> saveEmployeeDetails(@RequestBody @Valid EmployeeDetails employeeDetails) throws Exception {
		 
		return new ResponseEntity<String>(employeeService.saveEmployeeDetails(employeeDetails), HttpStatus.CREATED);
	}
	
	@GetMapping("/taxDetails")
	public ResponseEntity<List<EmployeeDetails>> fetchTaxDetails() throws Exception {
		 
		return new ResponseEntity<>(employeeService.getEmployeeTaxDetails(), HttpStatus.OK);
	}
}
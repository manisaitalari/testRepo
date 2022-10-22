package com.example.service;

import java.util.List;

import com.example.model.EmployeeDetails;

public interface EmployeeService {
	
	public String saveEmployeeDetails(EmployeeDetails employeeDetails) throws Exception;
	
	public List<EmployeeDetails> getEmployeeTaxDetails() throws Exception;

}

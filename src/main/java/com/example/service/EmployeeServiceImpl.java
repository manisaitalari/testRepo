package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.EmployeeRepository;
import com.example.entity.EmployeeEntity;
import com.example.model.EmployeeDetails;
import com.example.utils.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	 
	public String saveEmployeeDetails(EmployeeDetails employeeDetails) throws Exception {
		
		EmployeeEntity entity = EmployeeEntity.builder()
				.firstName(employeeDetails.getFirstName())
				.lastName(employeeDetails.getLastName())
				.email(employeeDetails.getEmail())
				.dateOfJoining(employeeDetails.getDateOfJoining())
				.phoneNumber1(employeeDetails.getPhoneNumber1())
				.phoneNumber2(employeeDetails.getPhoneNumber2())
				.salaryPerMonth(employeeDetails.getSalaryPerMonth()).build();
		try {
		entity = employeeRepository.saveAndFlush(entity);
		}catch (Exception e) {
			throw new Exception("Error while Saving the data");
		}
		
		return "Employee details saved with id : "+entity.getEmployeeId();
		
	}
	
	public List<EmployeeDetails> getEmployeeTaxDetails() throws Exception {

		List<EmployeeDetails> finalList = new ArrayList<>();		
		List<EmployeeEntity> employeeList = employeeRepository.findAll();
		if(employeeList.size()<=0) {
			throw new Exception("No records found");
		}
		
		employeeList.stream().forEach( employee -> {
			EmployeeDetails employeeDetails = EmployeeDetails.builder()
					.firstName(employee.getFirstName())
					.lastName(employee.getLastName())
					.employeeId(employee.getEmployeeId())
					.yearlySalary(EmployeeUtils.calculateYearlySalary(employee.getSalaryPerMonth(), employee.getDateOfJoining()))
					.taxAmount(EmployeeUtils.calculateTaxAmount(employee.getSalaryPerMonth(), employee.getDateOfJoining()))
					.cessAmount(EmployeeUtils.calcaulateCessAmount(employee.getSalaryPerMonth(), employee.getDateOfJoining())).build();
			finalList.add(employeeDetails);
		});
		
		return finalList;
		
	}
	

}

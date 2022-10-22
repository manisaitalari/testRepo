package com.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {
	
	private String employeeId;
	
	@NotNull(message ="Required parameter first name Missing")
	private String firstName;
	
	@NotNull(message ="Required parameter lastName Missing")
	private String lastName;

	@NotNull(message ="Required parameter email Missing")
	@Email(message = "Please Provide correct email")
	private String email;

	@NotNull(message ="Required parameter phone number Missing")
	private String phoneNumber1;
	
	private String phoneNumber2;

	@NotNull(message ="Required parameter date of joining Missing")
	private String dateOfJoining;

	@NotNull(message ="Required parameter monthly salary Missing")
	private String salaryPerMonth;
	
	private String yearlySalary;
	
	private long taxAmount;
	
	private long cessAmount;

}

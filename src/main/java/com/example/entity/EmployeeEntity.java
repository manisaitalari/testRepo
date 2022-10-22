package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Builder
public class EmployeeEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private String employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber1;
	
	private String phoneNumber2;

	private String dateOfJoining;

	private String salaryPerMonth;
}

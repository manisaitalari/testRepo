package com.example.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeUtils {

	public String calculateYearlySalary(String monthlySalary, String dataOfJoining) {
		Long salary = Long.parseLong(monthlySalary);
		LocalDate yearEndDate = LocalDate.parse("31-03-2022");
		LocalDate joiningDate = convertToDate(dataOfJoining);
		long monthsDiff = ChronoUnit.MONTHS.between(joiningDate, yearEndDate);
		// -1 to reduce joining date and to fid=nd no of days
		Long yearlySalary = salary * (monthsDiff - 1) + getDaysSalary(dataOfJoining, monthlySalary);
		return yearlySalary.toString();
	}

	public long calculateTaxAmount(String monthlySalary, String dataOfJoining) {
		Long yearlySalary = Long.parseLong(calculateYearlySalary(monthlySalary, dataOfJoining));
		yearlySalary = yearlySalary - 250000;
		if (yearlySalary <= 250000) {
			return 0;
		} else if (yearlySalary > 250000 && yearlySalary <= 500000) {
			return (yearlySalary * 5) / 100;
		} else if (yearlySalary > 500000 && yearlySalary <= 1000000) {
			return (yearlySalary * 10) / 100;
		} else if (yearlySalary > 1000000) {
			return (yearlySalary * 20) / 100;
		}
		return 0;
	}

	public long calcaulateCessAmount(String monthlySalary, String dataOfJoining) {
		Long yearlySalary = Long.parseLong(calculateYearlySalary(monthlySalary, dataOfJoining));
		if (yearlySalary > 250000) {
			return (yearlySalary * 2) / 100;
		} else
			return 0;
	}

	public LocalDate convertToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		return LocalDate.parse(date, formatter);
	}

	public long getDaysSalary(String dataOfJoining, String monthlySalary) {
		Long salary = Long.parseLong(monthlySalary);
		LocalDate date = convertToDate(dataOfJoining);
		int day = date.getDayOfMonth();
		int diff = 31 - day;
		return diff * (salary / 30);
	}

}

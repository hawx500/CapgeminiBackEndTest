package com.thales.dto;

public class EmployeeDTO {
	
	private Long employeId;
	
	private String employeeName;

	private Long employeeSalary;
	
	private Long employeeAnualSalary;
	
	private int employeeAge;
	
	private String employeeProfileImage;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Long employeId, String employeeName, Long employeeSalary, Long employeeAnualSalary, int employeeAge,
			String employeeProfileImage) {		
		this.employeId = employeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAnualSalary = employeeAnualSalary;
		this.employeeAge = employeeAge;
		this.employeeProfileImage = employeeProfileImage;		
	}

	public Long getEmployeId() {
		return employeId;
	}

	public void setEmployeId(Long employeId) {
		this.employeId = employeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Long getEmployeeAnualSalary() {
		return employeeAnualSalary;
	}

	public void setEmployeeAnualSalary(Long employeeAnualSalary) {
		this.employeeAnualSalary = employeeAnualSalary;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeeProfileImage() {
		return employeeProfileImage;
	}

	public void setEmployeeProfileImage(String employeeProfileImage) {
		this.employeeProfileImage = employeeProfileImage;
	}
	
}

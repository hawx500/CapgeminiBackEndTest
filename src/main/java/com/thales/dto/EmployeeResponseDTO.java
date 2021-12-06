package com.thales.dto;

import java.util.List;

public class EmployeeResponseDTO {
		
	public List<EmployeeDTO> empoyeeList;
	
	public int httpCode;
	
	public EmployeeResponseDTO() {
		
	}

	public EmployeeResponseDTO(List<EmployeeDTO> empoyeeList, int httpCode) {
		super();
		this.empoyeeList = empoyeeList;
		this.httpCode = httpCode;
	}

	public List<EmployeeDTO> getEmpoyeeList() {
		return empoyeeList;
	}

	public void setEmpoyeeList(List<EmployeeDTO> empoyeeList) {
		this.empoyeeList = empoyeeList;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

}

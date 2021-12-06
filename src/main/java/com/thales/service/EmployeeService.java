package com.thales.service;

import com.thales.dto.EmployeeResponseDTO;

public interface EmployeeService {
	
	public EmployeeResponseDTO findAllEmployee();
	
	public EmployeeResponseDTO findEmployeeById(String employeeId);

}

package com.thales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thales.dto.EmployeeResponseDTO;
import com.thales.service.EmployeeService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/findAllEmployee")
	public ResponseEntity<?> findEmployee() {
		EmployeeResponseDTO employeeResponseDto = new EmployeeResponseDTO();

		employeeResponseDto = employeeService.findAllEmployee();
		
		if (employeeResponseDto.getHttpCode() == 200) {
			return new ResponseEntity<EmployeeResponseDTO>(employeeResponseDto, HttpStatus.OK);			
		} else {
			return new ResponseEntity<EmployeeResponseDTO>(employeeResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}
	
	@RequestMapping("/findEmployeeById")
	public ResponseEntity<?> findEmployeeById(@RequestParam(value = "employeeId") String employeeId) {
		EmployeeResponseDTO employeeResponseDto = new EmployeeResponseDTO();

		employeeResponseDto = employeeService.findEmployeeById(employeeId);
		
		if (employeeResponseDto.getHttpCode() == 200) {
			return new ResponseEntity<EmployeeResponseDTO>(employeeResponseDto, HttpStatus.OK);
		} else if(employeeResponseDto.getHttpCode() == 202){
			return new ResponseEntity<EmployeeResponseDTO>(employeeResponseDto, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<EmployeeResponseDTO>(employeeResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

}

package com.thales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thales.dto.EmployeeDTO;
import com.thales.dto.EmployeeResponseDTO;
import com.thales.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public static final String URL_CALL_API_FULL = "http://dummy.restapiexample.com/api/v1/employees";
	
	public static final String URL_CALL_API_BY_ID = "http://dummy.restapiexample.com/api/v1/employee/";

	public EmployeeResponseDTO findAllEmployee() {
		String dataList = null;
		EmployeeDTO employee = null;
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		EmployeeResponseDTO objectData = new EmployeeResponseDTO();
		long employeeAnualSalary = 0;
		ResponseEntity<String> response = null;
		JSONArray dataArray = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			RestTemplate restTemplate = new RestTemplate();			
			
			response = restTemplate.exchange(URL_CALL_API_FULL, HttpMethod.GET, entity, new ParameterizedTypeReference<String>(){});			
			
			dataList = response.getBody();
			
			if(response.getStatusCodeValue() == 200) {
						
				JSONObject dataJson = new JSONObject(dataList);
								
				dataArray = dataJson.getJSONArray("data");
					
				for(int i=0;i<dataArray.length();i++) {
					employeeAnualSalary = dataArray.getJSONObject(i).getLong("employee_salary") * 12;
					employee = new EmployeeDTO(dataArray.getJSONObject(i).getLong("id"), dataArray.getJSONObject(i).getString("employee_name"),
											   dataArray.getJSONObject(i).getLong("employee_salary"), employeeAnualSalary, dataArray.getJSONObject(i).getInt("employee_age"),
											   dataArray.getJSONObject(i).getString("profile_image"));
					employeeList.add(employee);
				}														
				
				objectData.setEmpoyeeList(employeeList);
				objectData.setHttpCode(200);
				
			}else {
				objectData.setHttpCode(-1);
			}
			
		}catch (Exception e) {
			objectData.setHttpCode(-1);
		}
		return objectData;
	}

	@Override
	public EmployeeResponseDTO findEmployeeById(String employeeId) {
		String dataList = null;
		EmployeeDTO employee = null;
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		EmployeeResponseDTO objectData = new EmployeeResponseDTO();
		long employeeAnualSalary = 0;
		ResponseEntity<String> response = null;		
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			RestTemplate restTemplate = new RestTemplate();
						
			response = restTemplate.exchange(URL_CALL_API_BY_ID + employeeId, HttpMethod.GET, entity, new ParameterizedTypeReference<String>(){});
						
			dataList = response.getBody();
			
			if(response.getStatusCodeValue() == 200) {
						
				JSONObject dataJson = new JSONObject(dataList);				
					
				if(dataJson.get("data").toString().equalsIgnoreCase("null")) {
					
					objectData.setHttpCode(202);
					
					}else {
						
						JSONObject dataObject = dataJson.getJSONObject("data");
						
						employeeAnualSalary = dataObject.getLong("employee_salary") * 12;
						employee = new EmployeeDTO(dataObject.getLong("id"), dataObject.getString("employee_name"),
								                   dataObject.getLong("employee_salary"), employeeAnualSalary, dataObject.getInt("employee_age"),
								                   dataObject.getString("profile_image"));
							employeeList.add(employee);
							
							objectData.setEmpoyeeList(employeeList);
							objectData.setHttpCode(200);
						
					}
			}else {
				objectData.setHttpCode(-1);
			}
			
		}catch (Exception e) {
			objectData.setHttpCode(-1);
		}
		return objectData;
	}	
}

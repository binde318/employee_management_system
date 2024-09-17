package com.binde.ems.service;

import com.binde.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto>getAllEmployees();
    EmployeeDto update(Long employeeId, EmployeeDto updateEmployee);
    void deleteEmployee(Long employeeId);
}

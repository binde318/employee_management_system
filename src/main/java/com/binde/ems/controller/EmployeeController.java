package com.binde.ems.controller;

import com.binde.ems.dto.EmployeeDto;
import com.binde.ems.entity.Employee;
import com.binde.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
     EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
     return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }


    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id") Long employeeId){
      EmployeeDto employeeDto=  employeeService.getEmployeeById(employeeId);
      return ResponseEntity.ok(employeeDto);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployee(){
     List<EmployeeDto>employees =employeeService.getAllEmployees();
     return ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto>updatedEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
      EmployeeDto employeeDto=  employeeService.update(employeeId,updatedEmployee);
      return ResponseEntity.ok(employeeDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully! ");
    }
}

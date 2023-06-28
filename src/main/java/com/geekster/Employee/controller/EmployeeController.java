package com.geekster.Employee.controller;

import com.geekster.Employee.model.Employee;
import com.geekster.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getAllEmployee")
    List<Employee> getEmployee(){
        return employeeService.getAllEmployeeData();
    }

    @GetMapping(value = "/FetchEmployeeById/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeDataById(id);
    }

    @PostMapping(value = "/addEmployee")
    public String addEmployee(@RequestBody List<Employee> employees){
        return employeeService.addEmployeeData(employees);
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployeeData(id,employee);
    }

    @DeleteMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployeeData(id);
    }
}

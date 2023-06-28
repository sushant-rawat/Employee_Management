package com.geekster.Employee.service;

import com.geekster.Employee.model.Employee;
import com.geekster.Employee.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;


    public List<Employee> getAllEmployeeData() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public String addEmployeeData(List<Employee> employees) {
        employeeRepository.saveAll(employees);
        return "Data added successfully";
    }

    public String updateEmployeeData(int id,Employee employee) {
         Iterable<Employee> employees=employeeRepository.findAll();
         for (Employee employeeData:employees){
             if(employeeData.getEmployeeId()==id){
                 employeeData.setFirstName(employee.getFirstName());
                 employeeData.setLastName(employee.getLastName());
//                 employeeData.setAddress(employee.getAddress());
                 return "Employee data updated successfully";
             }
         }
         return "id not present";
    }

    public String deleteEmployeeData(int id) {
        employeeRepository.deleteById(id);
        return "Employee with id "+id+" has been deleted";
    }

    public Optional<Employee> getEmployeeDataById(int id) {
        return employeeRepository.findById(id);
    }
}

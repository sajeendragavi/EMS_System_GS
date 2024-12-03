package com.ProjectEM.EMS.service;

import com.ProjectEM.EMS.entity.Employee;
import com.ProjectEM.EMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee createEmployee(Employee employee){
        return  employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) throws Exception{
            return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));

    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) throws Exception{
        Employee employee = getEmployeeById(id);
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPhone(updatedEmployee.getPhone());
        employee.setDepartment(updatedEmployee.getDepartment());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

//    public List<Employee> getAllEmployees(){
//        return employeeRepository.findAll();
//    }

    //ppagination added

    public Page<Employee> getAllEmployees(Pageable pageable){
        return employeeRepository.findAll( pageable);
    }
}

package com.ProjectEM.EMS.service;

import com.ProjectEM.EMS.dto.DepartmentDTO;
import com.ProjectEM.EMS.dto.EmployeeDTO;
import com.ProjectEM.EMS.entity.Department;
import com.ProjectEM.EMS.entity.Employee;
import com.ProjectEM.EMS.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department Not found"));
    }

    public Department updateDepartment(Long id, Department updatedDepartment){
        Department department = getDepartmentById(id);
        department.setName(updatedDepartment.getName());
        department.setEmployees(updatedDepartment.getEmployees());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
//way1 to getall
//    public List<Department> getAllDepartments(){
//        return departmentRepository.findAll();
//    }
    //way 2 get all
    public List<DepartmentDTO> getAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        for(Department department : departments){
            List<EmployeeDTO> employeeDTOS = new ArrayList<>();
            for(Employee employee : department.getEmployees()){
                employeeDTOS.add(new EmployeeDTO(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail()
                ));
            }
            departmentDTOS.add(new DepartmentDTO(department.getId(),department.getName(),employeeDTOS));
        }
        return departmentDTOS;
    }
}

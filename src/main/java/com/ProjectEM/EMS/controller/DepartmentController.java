package com.ProjectEM.EMS.controller;

import com.ProjectEM.EMS.dto.DepartmentDTO;
import com.ProjectEM.EMS.entity.Department;
import com.ProjectEM.EMS.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
//way1
//    @PostMapping
//    public Department createDepartment(@RequestBody Department department){
//        return departmentService.createDepartment(department);
//    }
//way2
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department createdDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping({"/{id}"})
    public Department getDepartment(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping({"/{id}"})
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }

    @RequestMapping({"/{id}"})
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
//    @GetMapping
//    public List<Department> getAllDepartments(){
//        return departmentService.getAllDepartments();
//    }

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
}

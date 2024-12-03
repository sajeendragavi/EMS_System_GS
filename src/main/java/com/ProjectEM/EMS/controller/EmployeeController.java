package com.ProjectEM.EMS.controller;

import com.ProjectEM.EMS.dto.PaginatedResponseDTO;
import com.ProjectEM.EMS.entity.Employee;
import com.ProjectEM.EMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //newly added for the pagination
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    //

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        try{
            Employee savedEmployee = employeeService.createEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    public Employee createEmployee(@RequestBody Employee employee){
//        return employeeService.createEmployee(employee);
//
//    }

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping({"/{id}"})
    public Employee getEmployeeById(@PathVariable Long id) throws Exception{
        return employeeService.getEmployeeById(id);
    }

    @PutMapping({"/{id}"})
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) throws Exception{
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping({"/{id}"})
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }


//    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
//    @GetMapping
//    public List<Employee> getAllEmployees(){
//        return employeeService.getAllEmployees();
//    }

    //for pagination purpose changed the code

//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
//    @GetMapping
//    public Page<Employee> getAllEmployees(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size
//    ){
//        return employeeService.getAllEmployees(PageRequest.of(page,size));
//    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping
    public PaginatedResponseDTO<Employee> getAllEmployees(Pageable pageable){
        Page<Employee> employeePage = employeeService.getAllEmployees(pageable);
        return new PaginatedResponseDTO<>(employeePage);
    }

}

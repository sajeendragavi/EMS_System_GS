package com.ProjectEM.EMS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;

@Entity
public class Employee {

    @Id
    private Long id;



    //will do it validation
    private String firstName;
    private String lastName;


    @Column(unique = true, nullable = false)
    private String email;

    private String Phone;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    //@JsonIgnore  // Prevents infinite recursion
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

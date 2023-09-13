package com.example.eco.rich.employees.db;

import com.example.eco.rich.departments.db.Department;
import com.example.eco.rich.employees.model.EmployeePatchRequest;
import com.example.eco.rich.jobs.db.Job;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate hireDate;

    private BigDecimal salary;

    private BigDecimal commissionPct;

    //실제 직원의 부서
    @ManyToOne()
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToOne()
    @JoinColumn(name = "jobId")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee managerId;


    //부서와 메핑 되는 id
    @OneToOne(mappedBy = "employee",fetch = FetchType.EAGER)
    private Department departments;



    public static Employee ToPatchEntity(Employee employee2,EmployeePatchRequest employeePatchRequest){
             employee2.setFirstName(employeePatchRequest.getFirstName());
             employee2.setLastName(employeePatchRequest.getLastName());
             employee2.setEmail(employeePatchRequest.getEmail());
             employee2.setPhoneNumber(employeePatchRequest.getPhoneNumber());
             return employee2;
    }
}

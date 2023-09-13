package com.example.eco.rich.employees.model;

import com.example.eco.rich.departments.db.Department;
import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.jobs.db.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate hireDate;

    private BigDecimal salary;

    private BigDecimal commissionPct;

    private String jobId;

    private String jobTitle;

    private Integer mangerId;

    private String mFirstName;

    private String mLastName;


}

package com.example.eco.rich.departments.db;

import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.job_history.db.JobHistory;
import com.example.eco.rich.jobs.db.Job;
import com.example.eco.rich.locations.db.Location;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id",nullable = false,unique = true)
    private Integer departmentId;

    @Column(name = "department_name",nullable = false,unique = true)
    private String departmentName;

    @ManyToOne()
    @JoinColumn(name = "locationId")
    private Location location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @OneToOne()
    @JoinColumn(name = "managerId")
    private Employee employee;

    @OneToMany(mappedBy = "department")
    private List<JobHistory> jobHistories;

}

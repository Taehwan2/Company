package com.example.eco.rich.jobs.db;

import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.job_history.db.JobHistory;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Job {
    @Id
    @Column(name = "job_id", nullable = false)
    private String jobId;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "min_salary", unique = true)
    private BigDecimal minSalary;

    @Column(name = "max_salary", unique = true)
    private BigDecimal maxSalary;

    @OneToMany(mappedBy = "job")
    private List<Employee> employees;

    @OneToMany(mappedBy = "job")
    private List<JobHistory> jobHistories;
}

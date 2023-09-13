package com.example.eco.rich.job_history.db;

import com.example.eco.rich.departments.db.Department;
import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.jobs.db.Job;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "job_history")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobHistory {
    @EmbeddedId
    private JobKey jobKey;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "jobId")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;
}
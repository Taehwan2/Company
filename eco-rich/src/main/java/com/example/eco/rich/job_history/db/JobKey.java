package com.example.eco.rich.job_history.db;

import com.example.eco.rich.departments.db.Department;
import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.jobs.db.Job;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;


}
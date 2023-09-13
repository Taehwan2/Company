package com.example.eco.rich.departments.model;

import com.example.eco.rich.departments.db.Department;
import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.job_history.db.JobHistory;
import com.example.eco.rich.locations.db.Location;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    private Integer departmentId;


    private String departmentName;


    private String streetAddress;

    private String countryName;
    private String regionName;

    public static DepartmentResponse EntityToResponse(Department department){
        return  DepartmentResponse.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .streetAddress(department.getLocation().getStreetAddress())
                .countryName(department.getLocation().getCountry().getCountryName())
                .regionName(department.getLocation().getCountry().getRegion().getRegionName())
                .build();
    }

}


package com.example.eco.rich.employees.mapper;

import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.employees.model.EmployeePatchRequest;
import com.example.eco.rich.employees.model.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    void employeePatchRequestToEmployee(EmployeePatchRequest employeePatchRequest, @MappingTarget Employee employee);



    @Mapping(source = "employee.job.jobId", target = "jobId")
    @Mapping(source = "employee.job.jobTitle", target = "jobTitle")
    @Mapping(source = "employee.managerId.employeeId", target = "mangerId")
    @Mapping(source = "employee.managerId.firstName", target = "mFirstName")
    @Mapping(source = "employee.managerId.lastName", target = "mLastName")
    EmployeeResponse employeeToEmployeeResponse(Employee employee);


}
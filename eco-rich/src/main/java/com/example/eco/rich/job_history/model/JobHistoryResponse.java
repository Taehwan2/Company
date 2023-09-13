package com.example.eco.rich.job_history.model;

import com.example.eco.rich.job_history.db.JobHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobHistoryResponse {

    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobTitle;
    private String departmentName;

    public static JobHistoryResponse EntityToResponseDto(JobHistory jobHistory){
        return JobHistoryResponse.builder()
                .employeeId(jobHistory.getJobKey().getEmployee().getEmployeeId())
                .employeeFirstName(jobHistory.getJobKey().getEmployee().getFirstName())
                .employeeLastName(jobHistory.getJobKey().getEmployee().getLastName())
                .startDate(jobHistory.getJobKey().getStartDate())
                .endDate(jobHistory.getEndDate())
                .jobTitle(jobHistory.getJob().getJobTitle())
                .departmentName(jobHistory.getDepartment().getDepartmentName())
                .build();
    }
}

package com.example.eco.rich.job_history.controller;

import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.employees.service.EmployeeService;
import com.example.eco.rich.job_history.db.JobHistory;
import com.example.eco.rich.job_history.db.JobKey;
import com.example.eco.rich.job_history.model.JobHistoryResponse;
import com.example.eco.rich.job_history.service.JobHistroyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class JobHistroyController {
    private final JobHistroyService jobHistroyService;
    private final EmployeeService employeeService;

//    @GetMapping("jobhistory/{id}/{startDate}")
//    public ResponseEntity getEmployeeJobHistory(@PathVariable("id")int id, @PathVariable("startDate")LocalDate startDate){
//        Employee employee = employeeService.findById(id);
//        JobKey jobKey = new JobKey(employee,startDate);
//        JobHistory jobHistory = jobHistroyService.getEmployeeJobHistory(jobKey);
//        JobHistoryResponse jobHistoryResponse = JobHistoryResponse.EntityToResponseDto(jobHistory);
//        return new ResponseEntity(jobHistoryResponse, HttpStatus.ACCEPTED);
//    }

    @GetMapping("jobhistory/{id}")
    @ApiOperation(value = "특정 사원의 이력 정보 조회 가능한 API 구현", notes = "*무조건 이력 정보가 있어야함* 직원의 이력 정보에 대해서 조회 가능하다.")
    @ApiImplicitParam(name = "id",value = "직원아이디")
    public ResponseEntity getEmployeeJobHistoryId(@PathVariable("id")Integer id){
        Employee employee = employeeService.findById(id);
        List<JobHistory> jobHistory = jobHistroyService.getEmployeeJobHistory(id);
        List<JobHistoryResponse> jobHistoryResponses = jobHistory.stream().
                map((a)->JobHistoryResponse.EntityToResponseDto(a))
                .collect(Collectors.toList());
        return new ResponseEntity(jobHistoryResponses, HttpStatus.ACCEPTED);
    }
}

package com.example.eco.rich.employees.controller;

import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.employees.mapper.EmployeeMapper;
import com.example.eco.rich.employees.model.EmployeePatchRequest;
import com.example.eco.rich.employees.model.EmployeeResponse;
import com.example.eco.rich.employees.service.EmployeeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    @ApiOperation(value = "직원 정보 조회 ex)id값에 100입력", notes = "직원의 정보와 작업정보 메니저 정보를 알 수 있다.")
    @ApiImplicitParam(name = "id",value = "직원아이디")
    @GetMapping("/{id}")
    public ResponseEntity findEmployeeById(@PathVariable(name = "id")int id){
        return new ResponseEntity(employeeMapper.employeeToEmployeeResponse(employeeService.findById(id)), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "직원 정보 조회 ex)id값에 100입력", notes = "직원의 정보와 작업정보 메니저 정보를 알 수 있다. 위와 동일하지만, fetch join을 통해 효율 향상")
    @ApiImplicitParam(name = "id",value = "직원아이디")
    @GetMapping("/fetch/{id}")
    public ResponseEntity findEmployeeById2(@PathVariable(name = "id")int id){
        return new ResponseEntity(employeeMapper.employeeToEmployeeResponse(employeeService.findById2(id)), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/update/{id}")
    @ApiImplicitParam(name = "id",value = "직원아이디")
    @ApiOperation(value = "직원 정보 갱신", notes = "원하는 직원의 정보를 갱신할 수 있다.")
    public ResponseEntity updateEmpolyeeById(@RequestBody EmployeePatchRequest employeePatchRequest,@PathVariable("id")Integer id){
        Employee employee = employeeService.findById(id);
        employeeMapper.employeePatchRequestToEmployee(employeePatchRequest,employee);
     Employee employeeResponse = employeeService.saveEmployee(employee);
        return new ResponseEntity(employeeMapper.employeeToEmployeeResponse(employeeResponse),HttpStatus.ACCEPTED);
    }

}

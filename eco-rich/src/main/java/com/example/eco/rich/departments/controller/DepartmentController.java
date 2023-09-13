package com.example.eco.rich.departments.controller;

import com.example.eco.rich.departments.db.Department;
import com.example.eco.rich.departments.model.DepartmentResponse;
import com.example.eco.rich.departments.service.DepartmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class DepartmentController {
    private final DepartmentService departmentService;
    @ApiOperation(value = "부서 위치 및 정보 조회 ex)id값에 100입력", notes = "부서의 정보와 위치에 대해 알 수 있다.")
    @ApiImplicitParam(name = "id",value = "직원아이디")
    @GetMapping("department/{id}")
    public ResponseEntity getDeparment(@PathVariable("id") int id){
       Department department =  departmentService.findDepartmentById(id);
        DepartmentResponse departmentResponse = DepartmentResponse.EntityToResponse(department);
        return new ResponseEntity<>(departmentResponse, HttpStatus.OK);
    }
    @ApiOperation(value = "특정 부서의 급여를 특정 비율로 인상", notes = "부서의 급여 퍼센테이지를 입력하면 급여가바뀌게된다. ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "부서 아이디", required = true, dataType = "integer", paramType = "path"),
            @ApiImplicitParam(name = "percent", value = "백분율", required = true, dataType = "integer", paramType = "path")
    })
    @GetMapping("department/{id}/{percent}")
    public ResponseEntity updatePercent(@PathVariable("id") int id,@PathVariable("percent") int percent){
        Department department = departmentService.updateSalaryPercentage(id,percent);
        DepartmentResponse departmentResponse = DepartmentResponse.EntityToResponse(department);
        return new ResponseEntity<>(departmentResponse, HttpStatus.OK);
    }
}

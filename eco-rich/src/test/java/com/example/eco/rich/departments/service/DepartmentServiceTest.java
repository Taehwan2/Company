package com.example.eco.rich.departments.service;

import com.example.eco.rich.departments.db.Department;
import com.example.eco.rich.departments.db.DepartmentRepository;
import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.jobs.db.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
        departmentService = new DepartmentService(departmentRepository);
    }

    @Test
    public void testUpdateSalaryPercentage() {
        // 가짜 Department 객체 생성
        Department department = new Department();
        department.setDepartmentName("Test Department");

        // 가짜 Employee 객체와 Job 객체 생성
        Employee employee = new Employee();
        Job job = new Job();
        job.setMinSalary(BigDecimal.valueOf(1000));
        job.setMaxSalary(BigDecimal.valueOf(2000));
        job.setJobTitle("Test Job");
        employee.setJob(job);
        department.setEmployee(employee);

        // Mock Repository의 동작 정의
        when(departmentRepository.findById(101)).thenReturn(Optional.of(department));
        when(departmentRepository.save(any())).thenReturn(department);

        // 테스트 실행
        Department updatedDepartment = departmentService.updateSalaryPercentage(101, 10);

        // 검증
        assertEquals("Test Department", updatedDepartment.getDepartmentName());
        assertEquals("Test Job", updatedDepartment.getEmployee().getJob().getJobTitle());
        assertEquals(BigDecimal.valueOf(1100.0), updatedDepartment.getEmployee().getJob().getMinSalary());
        assertEquals(BigDecimal.valueOf(2200.0), updatedDepartment.getEmployee().getJob().getMaxSalary());
        // save 메서드가 호출되었는지 검증
        verify(departmentRepository, times(1)).save(updatedDepartment);
    }

    @Test
    public void testUpdateSalaryPercentageDepartmentNotFound() {
        // Mock Repository의 동작 정의: Department를 찾지 못하는 상황 모방
        when(departmentRepository.findById(101)).thenReturn(Optional.empty());

        // 테스트 실행 및 예외 처리 검증
        assertThrows(NoSuchElementException.class, () -> departmentService.updateSalaryPercentage(101, 10));
    }
}
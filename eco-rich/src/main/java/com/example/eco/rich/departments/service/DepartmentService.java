package com.example.eco.rich.departments.service;

import com.example.eco.rich.departments.db.Department;
import com.example.eco.rich.departments.db.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department findDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public Department updateSalaryPercentage(int id, int percent) {
        Department department = findDepartmentById(id);
        BigDecimal minSalary = department.getEmployee().getJob().getMinSalary();
        BigDecimal maxSalary = department.getEmployee().getJob().getMaxSalary();

        log.info("{}",department.getDepartmentName());
        log.info("{}",department.getEmployee().getJob().getJobTitle());

        log.info("{}",minSalary);
        log.info("{}",maxSalary);

        BigDecimal increaseRate = BigDecimal.valueOf(1 + (percent / 100.0));

        // 최소 급여와 최대 급여에 증가율을 곱하여 업데이트
        BigDecimal updatedMinSalary = minSalary.multiply(increaseRate);
        BigDecimal updatedMaxSalary = maxSalary.multiply(increaseRate);


        // 업데이트된 최소 급여와 최대 급여를 부서의 직원의 직업에 반영
        department.getEmployee().getJob().setMinSalary(updatedMinSalary);
        department.getEmployee().getJob().setMaxSalary(updatedMaxSalary);

        save(department);
        // 업데이트된 부서 객체 반환
        return department;
    }

    public Department save(Department department){
        return  departmentRepository.save(department);
    }
}

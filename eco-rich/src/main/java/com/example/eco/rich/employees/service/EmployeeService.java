package com.example.eco.rich.employees.service;

import com.example.eco.rich.employees.db.Employee;
import com.example.eco.rich.employees.db.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee findById(int id){
        return employeeRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findById2(int id){
        return employeeRepository.findByEmployeeId(id).orElseThrow(()->new NoSuchElementException());
    }
}

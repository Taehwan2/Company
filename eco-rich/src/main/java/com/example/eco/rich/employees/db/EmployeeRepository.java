package com.example.eco.rich.employees.db;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @EntityGraph(attributePaths = {"department","job"})
    Optional<Employee> findByEmployeeId(Integer integer);
}

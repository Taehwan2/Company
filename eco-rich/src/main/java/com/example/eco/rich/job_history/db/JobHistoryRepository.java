package com.example.eco.rich.job_history.db;

import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobHistoryRepository extends JpaRepository<JobHistory,JobKey> {

    Optional<JobHistory> findJobHistoriesByJobKey(JobKey jobKey);

    @Query("select a from JobHistory  a where a.jobKey.employee.employeeId=:id")
    Optional<List<JobHistory>> findJobHistoriesById(@Param("id") Integer id);

}

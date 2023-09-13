package com.example.eco.rich.job_history.service;

import com.example.eco.rich.job_history.db.JobHistory;
import com.example.eco.rich.job_history.db.JobHistoryRepository;
import com.example.eco.rich.job_history.db.JobKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobHistroyService {
  private final JobHistoryRepository jobHistoryRepository;

  public JobHistory getEmployeeJobHistory(JobKey jobKey){
      return jobHistoryRepository.findJobHistoriesByJobKey(jobKey).orElseThrow(()-> new NoSuchElementException());
  }
    public List<JobHistory> getEmployeeJobHistory(Integer id){
        return jobHistoryRepository.findJobHistoriesById(id).orElseThrow(()-> new NoSuchElementException());
    }
}

package hr.matija.springdemo.service;

import hr.matija.springdemo.entity.Job;
import hr.matija.springdemo.entity.Worker;

import java.util.List;
import java.util.Optional;

public interface JobService {

    Job create(Job job);

    List<Job> getAllJobs();

    void deleteJob(Long id);

    Optional<Job> getJobById(Long id);

}

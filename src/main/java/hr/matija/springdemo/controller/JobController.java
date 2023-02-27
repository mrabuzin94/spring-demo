package hr.matija.springdemo.controller;

import hr.matija.springdemo.entity.Job;
import hr.matija.springdemo.entity.Worker;
import hr.matija.springdemo.service.JobService;
import hr.matija.springdemo.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<String> saveWorker(@RequestBody Job job) {
        jobService.create(job);
        return ResponseEntity.ok("Job created!");
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteWorker(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted!");
    }

    @GetMapping(path = "/getAll")
    private ResponseEntity<List<Job>> getAllWorkers() {
        List<Job> allJobs = jobService.getAllJobs();
        return ResponseEntity.ok(allJobs);
    }

    @GetMapping(path = "/get/{id}")
    private ResponseEntity<Job> getById(@PathVariable Long id) {
        Optional<Job> optionalJob = jobService.getJobById(id);
        if(optionalJob.isPresent()) {
            return ResponseEntity.ok(optionalJob.get());
        }
        throw new RuntimeException("Worker does not exits in database!");
    }


}

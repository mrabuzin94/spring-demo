package hr.matija.springdemo.controller;

import hr.matija.springdemo.entity.Worker;
import hr.matija.springdemo.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<String> saveWorker(@RequestBody Worker worker) {
        workerService.create(worker);
        return ResponseEntity.ok("Worker created!");
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.ok("Worker deleted!");
    }


}

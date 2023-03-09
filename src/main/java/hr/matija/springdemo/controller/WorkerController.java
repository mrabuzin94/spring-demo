package hr.matija.springdemo.controller;

import hr.matija.springdemo.dto.WorkerDto;
import hr.matija.springdemo.entity.Worker;
import hr.matija.springdemo.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<String> saveWorker(@RequestBody WorkerDto workerDto) {
        workerService.create(workerDto);
        return ResponseEntity.ok("Worker created!");
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.ok("Worker deleted!");
    }

    @GetMapping(path = "/getAll")
    private ResponseEntity<List<Worker>> getAllWorkers() {
        List<Worker> allWorkers = workerService.getAllWorkers();
        return ResponseEntity.ok(allWorkers);
    }

    @GetMapping(path = "/get/{id}")
    private ResponseEntity<Worker> getById(@PathVariable Long id) {
        Optional<Worker> optionalWorker = workerService.getWorkerById(id);
        if(optionalWorker.isPresent()) {
            return ResponseEntity.ok(optionalWorker.get());
        }
        throw new RuntimeException("Worker does not exits in database!");
    }


}

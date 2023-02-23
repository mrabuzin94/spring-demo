package hr.matija.springdemo.service;

import hr.matija.springdemo.entity.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerService {

    Worker create(Worker worker);

    List<Worker> getAllWorkers();

    void deleteWorker(Long id);

    Optional<Worker> getWorkerById(Long id);

}

package hr.matija.springdemo.service;

import hr.matija.springdemo.dto.WorkerDto;
import hr.matija.springdemo.entity.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerService {

    WorkerDto create(WorkerDto worker);

    WorkerDto update(WorkerDto worker, Long id);

    List<Worker> getAllWorkers();

    void deleteWorker(Long id);

    Optional<Worker> getWorkerById(Long id);

}

package hr.matija.springdemo.service;

import hr.matija.springdemo.entity.Worker;
import hr.matija.springdemo.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker create(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }

    @Override
    public Optional<Worker> getWorkerById(Long id) {
        return workerRepository.findById(id);
    }
}

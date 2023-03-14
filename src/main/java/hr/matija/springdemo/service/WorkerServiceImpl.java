package hr.matija.springdemo.service;

import hr.matija.springdemo.dto.WorkerDto;
import hr.matija.springdemo.entity.Worker;
import hr.matija.springdemo.mapper.WorkerMapper;
import hr.matija.springdemo.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    public WorkerServiceImpl(WorkerRepository workerRepository, WorkerMapper workerMapper) {
        this.workerRepository = workerRepository;
        this.workerMapper = workerMapper;
    }

    @Override
    public WorkerDto create(WorkerDto workerDto) {

        Worker worker = workerRepository.save(workerMapper.workerDtoToWorker(workerDto));

        return workerDto;
    }

    @Override
    public WorkerDto update(WorkerDto workerDto, Long id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);

        if(optionalWorker.isPresent()) {
           workerMapper.updateWorkerFromWorkerDto(workerDto, optionalWorker.get());
           workerRepository.save(optionalWorker.get());
        } else {
            throw new RuntimeException("Worker does not exist");
        }

        return workerDto;
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

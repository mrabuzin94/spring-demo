package hr.matija.springdemo.repository;

import hr.matija.springdemo.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}

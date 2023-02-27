package hr.matija.springdemo.repository;

import hr.matija.springdemo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

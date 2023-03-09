package hr.matija.springdemo.entity;

import hr.matija.springdemo.dto.WorkerType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "worker")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worker_sequence")
    @SequenceGenerator(name = "worker_sequence", allocationSize = 10)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "workerType")
    @Enumerated(value = EnumType.STRING)
    private  WorkerType workerType;

    @OneToMany(mappedBy="worker", fetch = FetchType.EAGER)
    private List<Job> jobList;
}

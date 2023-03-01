package hr.matija.springdemo.entity;

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
    @SequenceGenerator(name = "car_sequence", allocationSize = 10)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @OneToMany(mappedBy="worker", fetch = FetchType.EAGER)
    private List<Job> jobList;
}

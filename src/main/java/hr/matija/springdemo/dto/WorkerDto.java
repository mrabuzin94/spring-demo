package hr.matija.springdemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class WorkerDto {

    private Long id;
    private String name;
    private Long age;
    private WorkerType workerType;
    private List<JobDto> jobList;
}

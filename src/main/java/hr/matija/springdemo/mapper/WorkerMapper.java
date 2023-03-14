package hr.matija.springdemo.mapper;

import hr.matija.springdemo.dto.JobDto;
import hr.matija.springdemo.dto.WorkerDto;
import hr.matija.springdemo.entity.Job;
import hr.matija.springdemo.entity.Worker;
import org.hibernate.jdbc.Work;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);

    @Mapping(source = "jobList", target = "jobList", qualifiedByName = "toJobDtos")
    WorkerDto workerToWorkerDto(Worker worker);

    Worker workerDtoToWorker(WorkerDto workerDto);

    @Named("toJobDtos")
    default List<JobDto> toJobDtos(List<Job> jobs) {
        if (jobs == null) {
            return null;
        }

        List<JobDto> jobDtos = new ArrayList<>(jobs.size());
        for (Job job : jobs) {
            jobDtos.add(JobMapper.INSTANCE.jobToJobDto(job));
        }
        return jobDtos;
    }

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePersonFromDto(WorkerDto workerDto, @MappingTarget Worker worker);

}
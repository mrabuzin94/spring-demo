package hr.matija.springdemo.mapper;

import hr.matija.springdemo.dto.JobDto;
import hr.matija.springdemo.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    @Mapping(source = "job.id", target = "id")
    JobDto jobToJobDto(Job job);

    List<JobDto> jobsToJobDtos(List<Job> jobs);

}

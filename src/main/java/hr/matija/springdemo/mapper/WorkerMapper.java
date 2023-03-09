package hr.matija.springdemo.mapper;

import hr.matija.springdemo.dto.WorkerDto;
import hr.matija.springdemo.entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    @Mapping(target = "id", ignore = true)
    Worker workerDtoToWorker(WorkerDto workerDto);

    WorkerDto workerToWorkerDto(Worker worker);

}

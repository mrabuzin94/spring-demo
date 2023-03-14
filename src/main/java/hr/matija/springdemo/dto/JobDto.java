package hr.matija.springdemo.dto;

import lombok.Data;

@Data
public class JobDto {

    private Long id;
    private String description;
    private Long workerId;

}

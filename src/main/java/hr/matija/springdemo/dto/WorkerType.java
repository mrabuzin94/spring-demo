package hr.matija.springdemo.dto;

import lombok.Getter;

@Getter
public enum WorkerType {

    OPEL("opel", "astra"),
    MANUFACTURER("manufacturer", "man"),
    DIRECTOR("director", "dir");

    private String label;
    private String shortLable;

    WorkerType(String label, String shortLable) {
        this.label = label;
        this.shortLable = shortLable;
    }
}

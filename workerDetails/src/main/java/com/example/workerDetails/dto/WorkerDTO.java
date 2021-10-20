package com.example.workerDetails.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class WorkerDTO {
    private  Integer id;

    private String name;

    private Integer age;

    private List<DepartmentDTO> departmentDTO;
}

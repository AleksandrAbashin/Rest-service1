package com.task.storage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {
    private Long id;
    private String name;
    @JsonIgnore
    private List<ApplicationDto> applications;
}


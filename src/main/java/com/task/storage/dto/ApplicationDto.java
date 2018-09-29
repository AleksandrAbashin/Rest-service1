package com.task.storage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
public class ApplicationDto {

    @JsonInclude(Include.NON_NULL)
    private Long id;
    private String productName;
    @JsonInclude(Include.NON_NULL)
    private String createdAt;
    private Long clientId;
}
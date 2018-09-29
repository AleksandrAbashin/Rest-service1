package com.task.storage.mapper;

import com.task.storage.domain.Application;
import com.task.storage.dto.ApplicationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    @Mapping(source = "clientId", target = "client.id")
    Application toApplication(ApplicationDto clientDto);

    @Mapping(source = "client.id", target = "clientId")
    ApplicationDto fromApplication(Application application);

    List<ApplicationDto> fromListApplication(List<Application> applications);
}
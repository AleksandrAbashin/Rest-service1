package com.task.storage.service;

import com.task.storage.domain.Application;
import com.task.storage.domain.Client;
import com.task.storage.dto.ApplicationDto;
import com.task.storage.exception.NotFoundException;
import com.task.storage.exception.ThereIsNoSuchContactIdException;
import com.task.storage.exception.ThereIsNoSuchProductNameException;
import com.task.storage.mapper.ApplicationMapper;
import com.task.storage.repos.ApplicationRepo;
import com.task.storage.repos.ClientRepo;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

interface ApplicationServiceInterface {

    List<ApplicationDto> getListAppByClientId(Long id);

    ApplicationDto createApplication(ApplicationDto applicationDto);

    ApplicationDto updateApplication(ApplicationDto applicationDto);

    ApplicationDto getLastApplication();
}

@Slf4j
@org.springframework.stereotype.Service
public class ApplicationService implements ApplicationServiceInterface {

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    private final ApplicationMapper mapper;

    public ApplicationService() {
        mapper = Mappers.getMapper(ApplicationMapper.class);
    }

    @Override
    public List<ApplicationDto> getListAppByClientId(Long id) {
        Client client = clientRepo.getOne(id);
        return mapper.fromListApplication(client.getApplications());
    }

    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = mapper.toApplication(applicationDto);

        if (applicationDto.getProductName() == null) {
            throw new ThereIsNoSuchProductNameException();
        }

        if (applicationDto.getClientId() == null) {
            throw new ThereIsNoSuchContactIdException();
        }

        application.setClient(clientRepo.getOne(applicationDto.getClientId()));

        application = applicationRepo.save(application);
        return mapper.fromApplication(application);
    }

    @Override
    public ApplicationDto updateApplication(ApplicationDto applicationDto) {
        Application application = mapper.toApplication(applicationDto);

        if (applicationDto.getProductName() == null) {
            throw new ThereIsNoSuchProductNameException();
        }

        return mapper.fromApplication(applicationRepo.save(application));
    }

    @Override
    public ApplicationDto getLastApplication() {
        Application app = applicationRepo
            .findAll()
            .stream()
            .max((Application app1, Application app2) ->
                app1.getCreatedAt().toString()
                .compareTo(app2.getCreatedAt().toString())).get();

        if (app == null)
            throw new NotFoundException();

        return mapper.fromApplication(app);
    }

    public void deleteApplication(Long id) {
        applicationRepo.deleteById(id);
    }
}

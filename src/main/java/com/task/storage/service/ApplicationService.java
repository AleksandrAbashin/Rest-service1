package com.task.storage.service;

import com.task.storage.Exception.NotFoundException;
import com.task.storage.Exception.ThereIsNoSuchContactIdException;
import com.task.storage.Exception.ThereIsNoSuchProductNameException;
import com.task.storage.domain.Application;
import com.task.storage.domain.Client;
import com.task.storage.dto.ApplicationDto;
import com.task.storage.repos.ApplicationRepo;
import com.task.storage.repos.ClientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@org.springframework.stereotype.Service
public class ApplicationService implements Service {

    @Autowired
    ApplicationRepo applicationRepo;
    @Autowired
    ClientRepo clientRepo;

    @Override
    public List<ApplicationDto> getListAppByContactId(Client client) {
        List<ApplicationDto> listAppDto = new ArrayList<ApplicationDto>();
        ApplicationDto appDto;
// TO DO convert method
        for ( Application app : client.getApplications()) {
            appDto = new ApplicationDto();
            appDto.setDate(app.getDtСreated().toString());
            appDto.setId(app.getApplicationId());
            appDto.setContact_id(app.getContact().getContactId());
            appDto.setProductName(app.getProductName());
            listAppDto.add(appDto);
        }
        return listAppDto;
    }

    @Override
    public ApplicationDto createApp(ApplicationDto applicationDto) {
        Application application = new Application();

        if(applicationDto.getProductName() == null)
                throw new ThereIsNoSuchProductNameException();

        application.setProductName(applicationDto.getProductName());

        if(applicationDto.getContact_id() == null)
            throw new ThereIsNoSuchContactIdException();

        Client client = clientRepo.getOne(applicationDto.getContact_id());

        application.setContact(client);

        application = applicationRepo.save(application);
        applicationDto.setId(application.getApplicationId());
        applicationDto.setDate(application.getDtСreated().toString());
        return applicationDto;
    }

    @Override
    public ApplicationDto updateApp(Long id, Long id_appli, ApplicationDto applicationDto) {
        Application application = applicationRepo.getOne(id_appli);
        Client client = clientRepo.findByContactId(id);

        if(applicationDto.getProductName() == null)
            throw new ThereIsNoSuchProductNameException();

        application.setProductName(applicationDto.getProductName());
        application.setDtСreated(LocalDateTime.now());

        applicationRepo.save(application);

        return applicationDto;

    }

    @Override
    public ApplicationDto getLastApp() {
        class ApplicationComparator implements Comparator<Application> {
            @Override
            public int compare(Application application, Application t1) {
                return application.getDtСreated().toString()
                        .compareTo(t1.getDtСreated().toString());
            }
        }

        ApplicationComparator comparator = new ApplicationComparator();
        Application app = applicationRepo
                .findAll()
                .stream()
                .max(comparator).get();

        if (app == null)
            throw new NotFoundException();

        ApplicationDto appDto = new ApplicationDto();
        appDto.setDate(app.getDtСreated().toString());
        appDto.setId(app.getApplicationId());
        appDto.setContact_id(app.getContact().getContactId());
        appDto.setProductName(app.getProductName());

        return appDto;
    }


    public List<Client> viewListContact() {
        return clientRepo.findAll();
    }


    public void deleteApp( Application application) {
        applicationRepo.delete(application);
    }


    public Client createContact(Client client) {
        return clientRepo.save(client);
    }

}

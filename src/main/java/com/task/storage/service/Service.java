package com.task.storage.service;

import com.task.storage.domain.Application;
import com.task.storage.domain.Client;
import com.task.storage.dto.ApplicationDto;

import java.util.List;

public interface Service {


    List<ApplicationDto> getListAppByContactId(Client client);

    ApplicationDto createApp(ApplicationDto applicationDto);

    ApplicationDto updateApp(Long id, Long id_appli, ApplicationDto applicationDto);

    ApplicationDto getLastApp();


}

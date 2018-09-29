package com.task.storage.service;

import com.task.storage.domain.Client;
import com.task.storage.dto.ClientDto;
import com.task.storage.mapper.ClientMapper;
import com.task.storage.repos.ClientRepo;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

interface ClientServiceInterface {

    List<ClientDto> listClient();

    ClientDto createClient(ClientDto client);

}

@org.springframework.stereotype.Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    private final ClientMapper mapper;

    public ClientService() {
        mapper = Mappers.getMapper(ClientMapper.class);
    }

    public List<ClientDto> listClient() {
        return mapper.fromListClient(clientRepo.findAll());
    }


    public ClientDto createClient(ClientDto client) {
        return mapper.fromClient(clientRepo.save(mapper.toClient(client)));
    }

}

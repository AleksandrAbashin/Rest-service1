package com.task.storage.mapper;

import com.task.storage.domain.Client;
import com.task.storage.dto.ClientDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toClient(ClientDto clientDto);

    ClientDto fromClient(Client client);

    List<ClientDto> fromListClient(List<Client> clients);
}
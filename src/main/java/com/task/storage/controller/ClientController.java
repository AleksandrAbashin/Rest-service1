package com.task.storage.controller;

import com.task.storage.dto.ClientDto;
import com.task.storage.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;


    @GetMapping
    public List<ClientDto> listClient() { return clientService.listClient();
    }


    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto client) {
        return clientService.createClient(client);
    }

}
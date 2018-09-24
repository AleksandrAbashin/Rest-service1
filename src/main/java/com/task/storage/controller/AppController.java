package com.task.storage.controller;

import com.task.storage.domain.Application;
import com.task.storage.domain.Client;
import com.task.storage.dto.ApplicationDto;
import com.task.storage.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "application")
public class AppController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("lastApp")
    public ApplicationDto lastApp() {
        return applicationService.getLastApp();
    }

    @GetMapping("/listApp/{contactId}")
    public List<ApplicationDto> getListApp(@PathVariable("contactId") Client client) {
        return applicationService.getListAppByContactId(client);
    }

    @PostMapping
    public ApplicationDto createApp(@RequestBody ApplicationDto applicationDto) {
        return applicationService.createApp(applicationDto);
    }

    @PostMapping("update/{id}/{id_appli}")
    public ApplicationDto updateApp(
            @PathVariable("id") Long id,
            @PathVariable("id_appli") Long id_appli,
            @RequestBody ApplicationDto applicationDto) {
       return applicationService.updateApp(id, id_appli, applicationDto);
    }

    @GetMapping
    public List<Client> viewListContact() {
        return applicationService.viewListContact();
    }

    @DeleteMapping("{id}")
    public void deleteApp(@PathVariable("id") Application application) {
        applicationService.deleteApp(application);
    }

    @PostMapping("contact")
    public Client createContact(@RequestBody Client client) {
        return applicationService.createContact(client);
    }

}
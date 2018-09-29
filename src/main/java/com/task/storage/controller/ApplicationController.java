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
@RequestMapping(path = "api/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("last")
    public ApplicationDto lastApplication() {
        return applicationService.getLastApplication();
    }

    @GetMapping("by-client/{id}")
    public List<ApplicationDto> getListApplication(@PathVariable("id") Long id) {
        return applicationService.getListAppByClientId(id);
    }

    @PostMapping
    public ApplicationDto createApplication(@RequestBody ApplicationDto applicationDto) {
        return applicationService.createApplication(applicationDto);
    }

    @PutMapping
    public ApplicationDto updateApplication(@RequestBody ApplicationDto applicationDto) {
       return applicationService.updateApplication(applicationDto);
    }

    @DeleteMapping("{id}")
    public void deleteApplication(@PathVariable("id") Long id) {
        applicationService.deleteApplication(id);
    }
}
package com.task.storage.repos;

import com.task.storage.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> { }
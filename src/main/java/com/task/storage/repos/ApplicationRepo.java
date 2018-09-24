package com.task.storage.repos;

import com.task.storage.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
    void deleteById(Long deliteOrder);
}

package com.task.storage.Converter;

import com.task.storage.domain.Application;
import com.task.storage.dto.ApplicationDto;

public interface Convertible {

    public ApplicationDto convertToDto(Application app);
}

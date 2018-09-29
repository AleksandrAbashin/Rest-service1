package com.task.storage.Converter;

import com.task.storage.domain.Application;
import com.task.storage.dto.ApplicationDto;

public class ConvertApplication implements Convertible {
    @Override
    public ApplicationDto convertToDto(Application app) {
        ApplicationDto appDto = new ApplicationDto();

        appDto.setDate(app.getDtСreated().toString());
        appDto.setId(app.getApplicationId());
        appDto.setContact_id(app.getContact().getContactId());
        appDto.setProductName(app.getProductName());

        return appDto;
    }


}

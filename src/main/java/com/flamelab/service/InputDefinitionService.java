package com.flamelab.service;

import com.flamelab.enums.DataType;
import com.flamelab.service.validator.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InputDefinitionService implements InputDefinition {

    @Autowired
    private List<Validator> validators;

    @Override
    public DataType defineOfData(String inputData) {
        log.info("Inputted data: {}", inputData);
        DataType result = DataType.UNKNOWN;

        for (Validator validator : validators) {
            DataType dataType = validator.validateData(inputData);

            if (dataType != DataType.UNKNOWN) {
                result = dataType;
            }
        }

        return result;
    }
}
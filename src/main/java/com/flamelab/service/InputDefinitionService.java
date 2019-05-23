package com.flamelab.service;

import com.flamelab.service.validator.ValidateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputDefinitionService implements InputDefinition {

    @Autowired
    private ValidateEngine validateEngine;

    @Override
    public DataType defineOfData(String inputData) {
        return validateEngine.validate(inputData);
    }
}
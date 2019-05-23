package com.flamelab.service;

import com.flamelab.service.validator.ValidateEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InputDefinitionService implements InputDefinition {

    @Autowired
    private ValidateEngine validateEngine;

    @Override
    public DataType defineOfData(String inputData) {
        log.info("Inputted data: {}", inputData);
        return validateEngine.validate(inputData);
    }
}
package com.flamelab.service.validator;

import com.flamelab.service.validator.utiles.Definer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PhoneValidator implements Validate {

    @Autowired
    private Definer definer;

    private String phoneRegEx = "^\\+?([1-9]{2})?[\\s]?[(]?[\\d]+[\\s)]?[\\s-_]?([\\d]{3})?[\\s-_]?([\\d]{2})?[\\s-_]?([\\d]{2})?${9,}/";

    @Override
    public boolean validateData(String inputData) {
        log.info("Phone validation");
        return definer.define(phoneRegEx, inputData);
    }
}
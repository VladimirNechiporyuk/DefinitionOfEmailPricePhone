package com.flamelab.service.validator;

import com.flamelab.service.validator.utiles.Definer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailValidator implements Validate {

    @Autowired
    private Definer definer;

    private String emailRegEx = "^\\b[a-zA-Z][a-zA-Z-0-9]*?@[a-z]+?\\Q.\\E[a-z]+\\b";

    @Override
    public boolean validateData(String inputData) {
        log.info("Email validation");
        return definer.define(emailRegEx, inputData);
    }
}

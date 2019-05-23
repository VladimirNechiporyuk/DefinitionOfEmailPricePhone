package com.flamelab.service.validator.utiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Definer implements Define {

    public boolean define(String regEx, String inputData) {
        boolean resultOfMatching = inputData.matches(regEx);
        log.info("Regular expression is: {}, Result of matching is: {}", regEx, resultOfMatching);
        return resultOfMatching;
    }
}

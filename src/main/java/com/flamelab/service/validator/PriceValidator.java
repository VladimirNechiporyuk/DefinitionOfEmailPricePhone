package com.flamelab.service.validator;

import com.flamelab.service.validator.utiles.Definer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriceValidator implements Validate {

    @Autowired
    private Definer definer;

    private String priceRegEx = "\\b[1-9]+?(([,.\\s]?([\\d]+))+)?\\b";

    @Override
    public boolean validateData(String inputData) {
        log.info("Price validation");
        return definer.define(priceRegEx, inputData);
    }
}

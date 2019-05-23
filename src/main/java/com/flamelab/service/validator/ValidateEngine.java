package com.flamelab.service.validator;

import com.flamelab.service.DataType;
import com.flamelab.service.validator.utiles.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateEngine {

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private PriceValidator priceValidator;

    @Autowired
    private PhoneValidator phoneValidator;

    public DataType validate(String inputData) {
        for (Pair pair : getValidators()) {
            if (pair.getValidator().validateData(inputData))
                return pair.getDataType();
        }
        return DataType.UNKNOWN;
    }

    private Pair[] getValidators() {
        return new Pair[]
                {new Pair(emailValidator, DataType.EMAIL),
                        new Pair(phoneValidator, DataType.PHONE),
                        new Pair(priceValidator, DataType.PRICE)};
    }
}
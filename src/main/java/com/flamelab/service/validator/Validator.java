package com.flamelab.service.validator;

import com.flamelab.enums.DataType;

public interface Validator {
    DataType validateData(String inputData);
}

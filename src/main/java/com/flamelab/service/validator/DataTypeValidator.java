package com.flamelab.service.validator;

import com.flamelab.enums.DataType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DataTypeValidator implements Validator {

    private String regexp;
    private DataType dataType;

    @Override
    public DataType validateData(String inputData) {
        boolean resultOfMatching = inputData.matches(regexp);
        log.info("Check for {}, Regular expression is: {}, Result of matching is: {}", dataType, regexp, resultOfMatching);

        return resultOfMatching ?
                dataType :
                DataType.UNKNOWN;
    }
}

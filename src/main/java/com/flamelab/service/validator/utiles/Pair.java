package com.flamelab.service.validator.utiles;

import com.flamelab.service.DataType;
import com.flamelab.service.validator.Validate;

public class Pair {
    public Validate validator;
    public final DataType dataType;

    public Pair(Validate validator, DataType dataType) {
        this.validator = validator;
        this.dataType = dataType;
    }
}

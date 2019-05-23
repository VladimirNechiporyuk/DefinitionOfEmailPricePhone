package com.flamelab.service.validator.utiles;

import com.flamelab.service.DataType;
import com.flamelab.service.validator.Validate;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pair {
    private Validate validator;
    private final DataType dataType;
}

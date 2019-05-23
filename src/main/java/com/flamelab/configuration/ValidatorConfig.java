package com.flamelab.configuration;

import com.flamelab.enums.DataType;
import com.flamelab.service.validator.DataTypeValidator;
import com.flamelab.service.validator.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {

    @Value("${regexp.phone}")
    private String phoneRegexp;

    @Value("${regexp.email}")
    private String emailRegexp;

    @Value("${regexp.price}")
    private String priceRegexp;

    @Bean
    public Validator phoneValidator() {
        return new DataTypeValidator(phoneRegexp, DataType.PHONE);
    }

    @Bean
    public Validator emailValidator() {
        return new DataTypeValidator(emailRegexp, DataType.EMAIL);
    }

    @Bean
    public Validator priceValidator() {
        return new DataTypeValidator(priceRegexp, DataType.PRICE);
    }

}

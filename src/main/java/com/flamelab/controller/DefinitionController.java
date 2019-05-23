package com.flamelab.controller;

import com.flamelab.enums.DataType;
import com.flamelab.service.InputDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/definition")
public class DefinitionController {

    @Autowired
    private InputDefinition inputDefinition;

    @GetMapping("/")
    @ResponseBody
    public Map<String, DataType> define(@RequestParam String inputData) {
        DataType resultOfDefinition = inputDefinition.defineOfData(inputData);

        Map<String, DataType> definitionResponse = new HashMap<>();
        definitionResponse.put("result", resultOfDefinition);

        return definitionResponse;
    }
}

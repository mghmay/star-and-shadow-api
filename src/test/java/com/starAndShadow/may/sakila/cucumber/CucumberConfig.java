package com.starAndShadow.may.sakila.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starAndShadow.may.sakila.MainApplication;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.Builder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.lang.reflect.Type;
@CucumberContextConfiguration
@SpringBootTest(classes = {
        MainApplication.class,
        RunCucumberTest.class
},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberConfig {
    private final ObjectMapper objectMapper;

    public CucumberConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @DefaultDataTableCellTransformer
    @DefaultDataTableEntryTransformer
    @DefaultParameterTransformer
    public Object transform(final Object from, final Type to) {
        return objectMapper.convertValue(from, objectMapper.constructType(to));
    }
}

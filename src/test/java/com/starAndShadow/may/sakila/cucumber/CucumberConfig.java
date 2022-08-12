package com.starAndShadow.may.sakila.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import lombok.Builder;

import java.lang.reflect.Type;

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

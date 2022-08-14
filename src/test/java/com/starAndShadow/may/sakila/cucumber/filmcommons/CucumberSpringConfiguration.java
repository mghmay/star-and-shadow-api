package com.starAndShadow.may.sakila.cucumber.filmcommons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starAndShadow.may.sakila.MainApplication;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Type;
@CucumberContextConfiguration
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {
//    private final ObjectMapper objectMapper;
//
//    public CucumberSpringConfiguration(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @DefaultDataTableCellTransformer
//    @DefaultDataTableEntryTransformer
//    @DefaultParameterTransformer
//    public Object transform(final Object from, final Type to) {
//        return objectMapper.convertValue(from, objectMapper.constructType(to));
//    }
}

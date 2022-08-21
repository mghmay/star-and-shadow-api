package com.starAndShadow.may.sakila;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(
        features={"src/test/resources/com.starAndShadow.may.sakila"},
        plugin = {"pretty"}
)
public class RunCucumberTest{
}
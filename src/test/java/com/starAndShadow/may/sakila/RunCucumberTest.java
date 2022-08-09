package com.starAndShadow.may.sakila;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/cucumber",
        glue = "com.starAndShadow.may.sakila"
)
public class RunCucumberTest{
}
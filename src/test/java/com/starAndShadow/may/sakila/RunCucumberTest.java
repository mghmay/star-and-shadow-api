package com.starAndShadow.may.sakila;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/com.starAndShadow.may.sakila"},
        plugin = {"pretty"}
)
public class RunCucumberTest{
}
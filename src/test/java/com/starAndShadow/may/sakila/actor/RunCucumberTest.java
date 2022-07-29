package com.starAndShadow.may.sakila.actor;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = "com.starAndShadow.may.sakila"
)
public class RunCucumberTest{
}
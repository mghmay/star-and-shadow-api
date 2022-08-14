package com.starAndShadow.may.sakila.cucumber.filmbasics;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features={"src/test/resources/features"},
    plugin={"pretty"}
)
public class FilmCucumberIntegrationTest {
}
package com.starAndShadow.may.sakila.cucumber;

import com.starAndShadow.may.sakila.MainApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = {
        MainApplication.class,
        RunCucumberTest.class
},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(
        features={"src/test/resources/com.starAndShadow.may.sakila"},
        plugin = {"pretty"}
)
public class RunCucumberTest{
}
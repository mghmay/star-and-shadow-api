package com.starAndShadow.may.sakila.cucumber.glue.film;

import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.http.HttpResponse;
import java.util.List;

public class FilmStepDefs {
    private static final String BASE_URL = "http://sample-env.eba-c2xqepzb.us-east-1.elasticbeanstalk.com/";
    private Response response;
    private Scenario scenario;


    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;

    }

    @Given("I am searching for a movie")
    public void searchForAMovie() {

    }

    @When("the user searches for the <title>")
    public void theUserSearchesForTheTitle() {

    }

    @Then("response body should match <response_body>")
    public void responseBodyShouldMatchResponse_body() {
    }

    @And("status_code  should equal <status_code>")
    public void status_codeShouldEqualStatus_code() {
    }
}

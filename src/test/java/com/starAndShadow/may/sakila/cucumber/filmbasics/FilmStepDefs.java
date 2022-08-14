package com.starAndShadow.may.sakila.cucumber.filmbasics;

import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.repository.FilmRepository;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class FilmStepDefs {
    private static final String BASE_URL = "http://sample-env.eba-c2xqepzb.us-east-1.elasticbeanstalk.com/";
    private Response response;
    private Scenario scenario;
    private String title;


    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("I am searching for a movie")
    public void searchForAMovie() {
        RestAssured.baseURI = BASE_URL;
        throw new io.cucumber.java.PendingException();
    }

    @When("the user searches for the {string}")
    public void theUserSearchesForTheTitle(String title) {
        this.response = given()
                .contentType(ContentType.JSON)
                .param("title", title)
                .when()
                .get("films/search")
                .then()
                .extract().response();
    }

    @Then("response id should match {string}")
    public void responseIdShouldMatch(String responseId) {
        String id = response.jsonPath().get("filmId");

        Assertions.assertEquals(responseId, id);
    }

    @And("status_code should equal {string}")
    public void status_codeShouldEqualStatus_code(String status_code) {
        String responseCode = String.valueOf(response.statusCode());
        Assertions.assertEquals(status_code, responseCode);
    }
}
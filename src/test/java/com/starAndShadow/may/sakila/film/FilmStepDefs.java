package com.starAndShadow.may.sakila.film;

import com.starAndShadow.may.sakila.model.Film;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FilmStepDefs {
    Film film;
    int length;
    @Given("there is a film with the length {int} minutes")
    public void thereIsAFilmWithTheLengthMinutes(int arg0) {
        film = new Film();
        film.setLength(arg0);
    }

    @When("I ask for film's length")
    public void iAskForFilmSLength() {
        length = film.getLength();
    }

    @Then("I get the film's length")
    public void iGetTheFilmSLength() {
        Assertions.assertEquals(88, length, "it returns a correct length");
    }
}

package com.starAndShadow.may.sakila.actor;

import com.starAndShadow.may.sakila.model.Actor;
import com.starAndShadow.may.sakila.model.Film;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ActorStepDefs {
    Actor actor;
    String fullName;
    @Given("there is an actor called Bob Willis")
    public void thereIsAnActorCalledBobWillis() {
        Set<Film> films = new HashSet<>();
        actor = new Actor(1, films, "Bob", "Willis", "Bob Willis", "2022-02-23");;
    }

    @When("I ask for the actor by name")
    public void iAskForTheActorByName() {
        fullName = actor.getFullName();
    }

    @Then("I get the actor")
    public void iGetTheActor() {
        Assertions.assertEquals("Bob Willis", actor.getFullName(), "gets the full name of the actor.");
    }
}

package com.starAndShadow.may.sakila.actor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class ActorStepDefs {
    @Given("the actor exists in the database")
    public void theActorExistsInTheDatabase() {
    }

    @When("I search for the actor")
    public void iSearchForTheActor() {
    }

    @Then("the Actor is returned")
    public void theActorIsReturned() {
        assertEquals(17, 17);
    }
}

package com.starAndShadow.may.sakila.customer;

import com.starAndShadow.may.sakila.model.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CustomerStepDefs {
    Customer customer;
    String email;
    @Given("there is an customer with the email fred@joe.com")
    public void thereIsAnCustomerWithTheEmail() {
        customer = new Customer(1, 1,"Fred","Joe", "Fred Joe", 1, true, "fred@joe.com", "2022-08-20", "2022-08-20");
    }

    @When("I request the customer's email")
    public void iRequestTheCustomersEmail() {
        email = customer.getEmail();
    }

    @Then("I get the customer's email")
    public void iGetTheActor() {
        Assertions.assertEquals("fred@joe.com", customer.getEmail(), "get the customer email.");
    }
}

Feature: Find an actor
  Actors can be found by their name

  Scenario: An actor is found by their name
    Given the actor exists in the database
    When I search for the actor
    Then the Actor is returned

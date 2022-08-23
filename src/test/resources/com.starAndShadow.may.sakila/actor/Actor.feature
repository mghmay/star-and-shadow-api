Feature: A user can get actor details


  Scenario: Get the actor's name
    Given there is an actor called Bob Willis
    When I ask for the actor by name
    Then I get the actor
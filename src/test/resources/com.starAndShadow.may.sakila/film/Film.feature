Feature: A user can find out information about a film


  Scenario: Get the film's length
    Given there is a film with the length 88 minutes
    When I ask for film's length
    Then I get the film's length
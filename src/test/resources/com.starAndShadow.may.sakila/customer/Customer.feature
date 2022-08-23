Feature: A member of staff can get customer details


  Scenario: Get the customer's email
    Given there is an customer with the email fred@joe.com
    When I request the customer's email
    Then I get the customer's email
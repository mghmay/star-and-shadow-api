Feature: Films
  Films can be found, edited, updated and deleted.

  @validFilmTitle
  Scenario Outline: A user searches for a film by title
    Given I am searching for a film
    When I search for <title>
    Then response body should match <response_body>
    And  status_code  should equal <status_code>
    Examples:
      | title            | response_body   | status_code |
      | ACADEMY DINOSAUR | response1       | 200         |
      | happiness united | response2       | 200         |
      | rEiGn            | response3       | 200         |
      | asdfasdfasdf     |                 | 400         |
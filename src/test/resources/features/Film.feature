Feature: Films
  Films can be found, edited, updated and deleted.

  @validFilmTitle
  Scenario Outline: A user searches for a film by title
    Given I am searching for a movie
    When the user searches for the "<title>"
    Then response id should match "<response_id>"
    And  status_code should equal "<status_code>"
    Examples:
      | title            | response_id   | status_code |
      | ACADEMY DINOSAUR | 1             | 200         |
      | happiness united | 399           | 200         |
      | rEiGn            | 434           | 200         |
      | asdfasdfasdf     |               | 400         |
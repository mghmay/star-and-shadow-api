Feature: Films
  Films can be found, edited, updated and deleted.

#    Scenario: A user searches for all films
#    Given the database is running
#    When I search for all the films
#    Then All the films should be returned
#    And the status_code should equal 200

  Scenario: A user searches for a film by title
    Given the movie exists in the database
    When I search for the title dino
    Then response id should match 1
    And the status_code should equal 200
#    Examples:
#      | title            | response_id   | status_code |
#      | ACADEMY DINOSAUR | 1             | 200         |
#      | happiness united | 399           | 200         |
#      | rEiGn            | 434           | 200         |
#      | asdfasdfasdf     |               | 400         |
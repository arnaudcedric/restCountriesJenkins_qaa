#@GetAllCountries
Feature: Get all countries

  Scenario: User should be able to see all countries in the world

    Given user makes a get request to get list of all countries
    Then the status code is "200"
    And "250" countries are returned

  Scenario Outline: Countries has the correct population count
    Given user makes a get request to get list of all countries
    And the status code is "<statusCode>"
    Then the population for "<countryName>" is "<populationNumber>"

    Examples:
      | countryName   | populationNumber | statusCode |
      | belgium       | 11248330         | 200        |
      | Afghanistan   | 26023100         | 200        |
      | Åland Islands | 28875            | 200        |
      | Albania       | 2893005          | 200        |

    Scenario: Belgiem has the correct languages defined
      Given user makes a get request to get list of all countries
      And the status code is "200"
      Then languages for "Belgium" are:
        |nl|
        |fr|
        |de|

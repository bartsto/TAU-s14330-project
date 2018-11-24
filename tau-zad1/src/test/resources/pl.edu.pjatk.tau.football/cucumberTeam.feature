Feature: Cucumber tests

  Background:
    Given we have empty list of teams

  Scenario Outline: Search team name by regex should give some result
    And we will create two teams
    When we will search first team name by partial <text>
    Then the result should be <result>

    Examples:
      | text      | result |
      | "chest"   | "Manchester United" |
      | "anch"    | "Manchester United" |
      | "ted"     | "Manchester United" |
      | "ten"     | "Tottenham" |
      | "ham"     | "Tottenham" |
      | "enh"     | "Tottenham" |
      | "tekst"   | "No result." |

  Scenario: Delete team by provided list of teams
    And we will create three teams
    When we will delete teams by provided list of teams names
    Then the result should be 1

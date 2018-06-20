Feature: Checking Search for property block

  Scenario Outline: Search for property
    Given Accommodation page is opened
    When Enter "<destination>" to search
    When Select Check-in date to search "<plusIn>" day from today
    When Select Check-out date "<plusOut>" day from Today
#    When Select guests info "<rooms>", "<adults>", "<children>" to search
#    When Click on Search destination button
    Examples:
      | destination | plusIn | plusOut | rooms | adults | children |
      | Hamburg     | 96       | 98        | 1     | 2      | 2        |
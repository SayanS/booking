Feature: Checking Search for property block

  Scenario Outline: Search for property
    Given Accommodation page is opened
    When Enter "<destination>" to search
    When Select Check-in date to search "<plusIn>" day from today
    When Select Check-out date "<plusOut>" day from Today
    When Select guests info "<rooms>", "<adults>", "<children>", "<ages>" to search
    When Click on Search destination button
    Then The title of Search results page should contain "<destination>"
    Examples:
      | destination | plusIn | plusOut | rooms | adults | children | ages     |
      | Hamburg     | 96     | 98      | 3     | 3      | 4        | 3,8,12,5 |

  Scenario Outline: Check Search results filter
    Given Accommodation page is opened
    When Select "en-gb" as current language
    When Enter "<destination>" to search
    When Select Check-in date to search "<plusIn>" day from today
    When Select Check-out date "<plusOut>" day from Today
    When Select guests info "<rooms>", "<adults>", "<children>", "<ages>" to search
    When Click on Search destination button
    Then The title of Search results page should contain "<destination>"
    When Select option number "3" of the "Star rating" Search results filter
    When Select option number "2" of the "Your budget" Search results filter

    Examples:
      | destination | plusIn | plusOut | rooms | adults | children | ages                  |
      | Hamburg     | 96     | 98      | 3     | 3      | 10       | 0,1,3,4,5,6,7,8,16,17 |

  Scenario Outline: Check that click on Hotel name is opened Hotel details page
    Given Accommodation page is opened
    When Enter "<destination>" to search
    When Click on Search destination button
    When Click on Hotel name of the "1" item in the Search results
    Then Appropriate Hotel details page should be opened in a new browser tab
    Then Hotel details page should be opened in a new browser tab with the title of clicked Hotel name
    Then Hotel details page should contain "<destination>" in Hotel address
    Examples:
      | destination |
      | Hamburg     |
      | Moscow      |
      | Morocco     |

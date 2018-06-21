Feature: Checking localization of Accommodation page

  Scenario Outline: Check ability to change language
    Given Accommodation page is opened
    When Select "<country>" as current language
    Examples:
      | country |
      | ru      |
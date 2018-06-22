Feature: Checking localization of Accommodation page

  Scenario Outline: Check ability to change language
    Given Accommodation page is opened
    When Select "<language>" as current language
    Then Texts of "Main menu items" should be translated into "<language>"
    Then Texts of "Search section title" should be translated into "<language>"
    Then Texts of "Search section sub title" should be translated into "<language>"
    Then Texts of "Accommodation page - Top header buttons" should be translated into "<language>"
    Examples:
      | language |
      | ru      |
      | en-us   |
      | sl      |

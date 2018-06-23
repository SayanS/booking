Feature: Checking localization of Accommodation page

  Scenario Outline: Check that the language of the text on the page is changes accordingly the language selection
    Given Accommodation page is opened
    When Select "<language>" as current language
    Then Texts of "Main menu items" should be translated into "<language>"
    Then Texts of "Search section title" should be translated into "<language>"
    Then Texts of "Search section sub title" should be translated into "<language>"
    Then Texts of "Accommodation page - Top header buttons" should be translated into "<language>"
    Examples:
      | language |
      | ru       |
      | en-us    |
      | sl       |

  Scenario Outline: Check that current language is displayed as selected in the Language selector popup
    Given Accommodation page is opened
    When Select "<language>" as current language
    Then Current language button in Header should be shown with the image "<imageUrl>"
    When Click on Select language button in Header
    Then Item "<language>" should be shown as selected in Language selector popup
    Examples:
      | language | imageUrl                                                                                     |
      | ru       | https://t-ec.bstatic.com/static/img/flags/24/ru/88fbb4ed75a0daae6222ed2426e26cef1537eecd.png |
      | en-us    | https://t-ec.bstatic.com/static/img/flags/24/us/e39c170c852301a1817b3d0833be23f677a2f922.png |
      | sl       | https://t-ec.bstatic.com/static/img/flags/24/si/1796c97012113899bba68e2688ad03e53860819a.png |



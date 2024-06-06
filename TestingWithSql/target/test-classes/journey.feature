Feature: Buying a book in amazon

  Scenario: Customer buys the third book after searching
    Given I enter the amazon website
    And I enter "C programming books" in search field
    When I click enter
    And I select the third book from the result
    Then I display the details of the book
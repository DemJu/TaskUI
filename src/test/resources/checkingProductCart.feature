#language:en
Feature: Checking for the display of items in the basket and removing items from the basket

  Background:
    Given I open my store search page

  Scenario:
    When I write text "Faded Short Sleeve T-shirts" to search input
    And I click button to search it
    Then I click on the found product
    And I click on the buy product button
    And I click the button to close the order preview window
    And I check that the basket is not empty
    Given I click on the basket button
    Then Deleting an item from the shopping cart
    And I will check that the basket is empty
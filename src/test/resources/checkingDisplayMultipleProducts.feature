#language:en
Feature: Checking the display of products in the shopping cart after deleting one

  Background:
    Given I open my store search page

  Scenario:
    When I write text "Faded Short Sleeve T-shirts" to search input
    And I click button to search it
    Then I click on the found product
    And I click on the increase the quantity of goods button
    And I click on the buy product button
    And I click the button to close the order preview window
    And Let's check that there is "2" product in the basket
    Given I click on the basket button
    And I click on the button to reduce the number of products
    Then Let's check that there is "1" product in the basket

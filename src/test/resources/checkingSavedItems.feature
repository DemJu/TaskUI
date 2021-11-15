#language:en
Feature: Checking products on a new page

  Background:
    Given I open my store search page

  Scenario:
    When I write text "Faded Short Sleeve T-shirts" to search input
    And I click button to search it
    Then I click on the found product
    And I click on the buy product button
    And I click the button to close the order preview window
    Then I have updated the tab
    And I check that the basket is not empty
#Autor Edwin Quintero

@Filter
Feature: Product filtering

  Scenario: Successfully filter products by price (low to high)
    Given the user is logged in with the username "standard_user" and the password "secret_sauce"
    When the user selects the "Price (low to high)" option from the filter dropdown
    Then the products should be displayed in ascending order of price

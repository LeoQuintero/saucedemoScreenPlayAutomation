#Autor Edwin Quintero

@OrderedTests
Feature: Purchase functionality

  @Order(2)
  Scenario: Successfully purchase two products
    Given the user is logged in with the username "standard_user" and the password "secret_sauce"
    When the user adds the first product to the cart
    And the user adds the second product to the cart
    And the user clicks on the shopping cart icon
    And the user clicks on the "Checkout" button
    And the user enters first name "John", last name "Doe", and postal code "12345"
    And the user clicks on the "Continue" button
    And the user clicks on the "Finish" button
    Then the user should see the message "THANK YOU FOR YOUR ORDER"

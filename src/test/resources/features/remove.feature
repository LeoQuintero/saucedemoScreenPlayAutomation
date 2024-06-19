Feature: Cart functionality

  Scenario: Successfully remove purchased products from the cart
    Given the user is logged in with the username "standard_user" and the password "secret_sauce"
    And the user has two products in the cart
    When the user clicks on the shopping cart icon
    And the user removes the first product from the cart
    And the user removes the second product from the cart
    Then the cart should be empty
    And the user should see the message "Your cart is empty"

Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given the user is on the Sauce Demo login page
    When the user enters the username "standard_user" and the password "secret_sauce"
    And the user clicks on the login button
    Then the user should be redirected to the inventory page
    And the user should see the title "Products"

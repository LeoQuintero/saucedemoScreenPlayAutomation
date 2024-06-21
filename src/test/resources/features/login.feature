#Autor Edwin Quintero

@OrderedTests
Feature: Login functionality

@Order(1)
  Scenario: Successful login with valid credentials
    Given the user is on the Sauce Demo login page
    When the user enters the username "standard_user" and the password "secret_sauce"
    Then the user should be redirected to the inventory page
    And the user should see the title "Products"

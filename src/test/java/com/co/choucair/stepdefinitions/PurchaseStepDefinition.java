package com.co.choucair.stepdefinitions;

import com.co.choucair.tasks.Login;
import com.co.choucair.tasks.PurchaseProducts;
import com.co.choucair.utils.SessionState;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.co.choucair.userinterfaces.CartPage.ORDER_CONFIRMATION_MESSAGE;
import static com.co.choucair.utils.GlobalData.ACTOR;
import static com.co.choucair.utils.GlobalData.URL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PurchaseStepDefinition {

    @Before
    public void setup(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is logged in with the username {string} and the password {string}")
    public void theUserIsLoggedInWithTheUsernameAndThePassword(String username, String password) {
        //if (!SessionState.isLoggedIn()) {
            OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
            theActorInTheSpotlight().attemptsTo(Login.withCredentials(username,password));
            SessionState.setLoggedIn(true);
      //  }
    }
    @When("the user adds the first product to the cart")
    public void theUserAddsTheFirstProductToTheCart() {
        theActorInTheSpotlight().attemptsTo(PurchaseProducts.addFirstProduct());
    }
    @And("the user adds the second product to the cart")
    public void theUserAddsTheSecondProductToTheCart() {
        theActorInTheSpotlight().attemptsTo(PurchaseProducts.addSecondProduct());
    }
    @And("the user clicks on the shopping cart icon")
    public void theUserClicksOnTheShoppingCartIcon() {
        theActorInTheSpotlight().attemptsTo(PurchaseProducts.clickOnShoppingCartIcon());
    }
    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        switch (button) {
            case "Checkout":
                theActorInTheSpotlight().attemptsTo(PurchaseProducts.clickCheckoutButton());
                break;
            case "Continue":
                theActorInTheSpotlight().attemptsTo(PurchaseProducts.clickContinueButton());
                break;
            case "Finish":
                theActorInTheSpotlight().attemptsTo(PurchaseProducts.clickFinishButton());
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + button);
        }
    }
    @And("the user enters first name {string}, last name {string}, and postal code {string}")
    public void theUserEntersFirstNameLastNameAndPostalCode(String firstName, String lastName, String postalCode) {
        System.out.println("Entering user info in step definition:");
        System.out.println("  - First Name: " + firstName);
        System.out.println("  - Last Name: " + lastName);
        System.out.println("  - Postal Code: " + postalCode);
        theActorInTheSpotlight().attemptsTo(PurchaseProducts.enterUserInfo(firstName, lastName, postalCode));
    }

    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String expectedMessage) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(ORDER_CONFIRMATION_MESSAGE).text().isEqualTo(expectedMessage)
        );
    }


}
